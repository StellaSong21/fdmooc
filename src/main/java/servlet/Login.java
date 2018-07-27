package servlet;

import dao.DAOFactory;
import dao.UserDAO;
import entity.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;


@WebServlet(name = "login", urlPatterns = "/login.action")
public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取登录信息
        //用户名
        String username = request.getParameter("username");

        //密码
        String password = request.getParameter("password");

        //UserDAO
        UserDAO userDAO =  DAOFactory.getUserDAOInstance();

        //user的JavaBean对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        if(userDAO.append(user) == 1) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}
