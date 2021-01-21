package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.User;
import nongsan.webmvc.service.UserService;
import nongsan.webmvc.service.impl.UserServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addAdmin", urlPatterns = "/admin/admin/add")
public class AdminAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService adminService = new UserServicesImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String admin_roleid= request.getParameter("user-roleid");
        String admin_name = request.getParameter("user-name");
        String admin_email = request.getParameter("user-email");
        String admin_phone = request.getParameter("user-phone");
        String admin_username = request.getParameter("user-userName");
        String admin_password = request.getParameter("user-password");
        String admin_status = request.getParameter("user-status");
        String admin_created = request.getParameter("user-created");

        User admin = new User();
        admin.setRoleid(Integer.parseInt(admin_roleid));
        admin.setName(admin_name);
        admin.setEmail(admin_email);
        admin.setPhone(admin_phone);
        admin.setUsername(admin_username);
        admin.setPassword(admin_password);
        admin.setStatus(Integer.parseInt(admin_status));
        admin.setCreated(admin_created);
        adminService.insert(admin);
        response.sendRedirect(request.getContextPath() + "/admin/admin/list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/addadmin.jsp");
        dispatcher.forward(request, response);
    }
}
