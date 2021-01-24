package nongsan.webmvc.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminHomePage", urlPatterns = "/admin/homepage")
public class AdminHomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminHomePage() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/index.jsp");
        dispatcher.forward(request,response);
    }

}
