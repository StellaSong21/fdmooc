package servlet;

import com.google.gson.JsonObject;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        JsonObject param = new JsonObject();
        Map<String, String[]> h = request.getParameterMap();
        for (Map.Entry<String, String[]> e : h.entrySet())
            param.addProperty(e.getKey(), e.getValue()[0]);
        System.out.println(param.toString());
        switch (request.getParameter("type")) {
            case "page":
                pw.print(ServiceFactory.getCourseServiceInstance(param).getCoursePageInfo());
                break;
            case "add_record":
                pw.print(ServiceFactory.getCourseServiceInstance(param).createRecord());
                break;
            case "tophot":
                pw.print(ServiceFactory.getCourseServiceInstance().getTopHotCourse());
                break;
            case "latestcourse":
                pw.print(ServiceFactory.getCourseServiceInstance().getLatestCourse());
                break;
            case "login":
                pw.print(ServiceFactory.getUserServiceInstance(param).login());
                break;
            case "mail":
                pw.print(ServiceFactory.getUserServiceInstance(param).sendVerifyCode());
                break;
            case "hasUsername":
                pw.print(ServiceFactory.getUserServiceInstance().hasUsername(request.getParameter("username")));
                break;
            case "register":
                pw.print(ServiceFactory.getUserServiceInstance(param).register());
                break;
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
