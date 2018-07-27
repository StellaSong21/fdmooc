package servlet;

import dao.DAOFactory;
import dao.UserDAO;
import entity.UserBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.action")
public class Register extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取注册信息
        //用户名
        String username = request.getParameter("username");
        //昵称
        String nickname = request.getParameter("nickname");
        //密码
        String password = request.getParameter("password");
        //邮箱
        String email = request.getParameter("email");
        //验证码
        String captcha = request.getParameter("captcha");

        //UserDAO
        UserDAO userDAO =  DAOFactory.getUserDAOInstance();

        //user的JavaBean对象
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setEmail(email);


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

