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

@WebServlet(name = "editAdmin", urlPatterns = "/admin/admin/edit")
public class AdminEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("id"));
        User user = userService.get(user_id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editadmin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int user_id = Integer.parseInt(request.getParameter("user-id"));
        int user_roleid= Integer.parseInt(request.getParameter("user-roleid"));
        String user_name = request.getParameter("user-name");
        String user_email = request.getParameter("user-email");
        String user_phone = request.getParameter("user-phone");
        String user_userName = request.getParameter("user-userName");
        String user_password = request.getParameter("user-password");
        int user_status= Integer.parseInt(request.getParameter("user-status"));
        String user_created = request.getParameter("user-created");


        User user = new User();
        user.setRoleid(user_roleid);
        user.setName(user_name);
        user.setEmail(user_email);
        user.setPhone(user_phone);
        user.setUsername(user_userName);
        user.setPassword(user_password);
        user.setCreated(user_created);
        user.setStatus(user_status);
        user.setId(user_id);
        userService.edit(user);
        response.sendRedirect(request.getContextPath() + "/admin/admin/list");
        //resp.sendRedirect(req.getContextPath() + "/view/admin/user.jsp");
    }
}
