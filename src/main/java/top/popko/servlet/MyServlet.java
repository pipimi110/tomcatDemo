package top.popko.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet中*表示多级路径，不支持**
@WebServlet(value = {"/servleturl","/qwe/*","/abc/**"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //xxe
//        super.doGet(req, resp);
        System.out.println("----");
        System.out.println(request.getContextPath());
        String password = request.getParameter("password");
//        try {
//            UserService.testRun(password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}