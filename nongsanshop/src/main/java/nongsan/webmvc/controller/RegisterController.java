package nongsan.webmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.dao.impl.RegisterDaoImpl;
import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.User;

/**
 * Servlet implementation class RegistrationController
 */

public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/register.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int roleid = Integer.parseInt(request.getParameter("roleid"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int status = Integer.parseInt(request.getParameter("status"));
        String created = request.getParameter("created");


        User user = new User(roleid,email, name, phone, username, password,status, created);

        RegisterDaoImpl register = new RegisterDaoImpl(connectDB.getConnect());
        if (register.RegisterUser(user)) // On success, you can display a message to user on Home page
        {
            request.setAttribute("Message", "Bạn đã tạo tài khoàn thành công. Mời bạn đăng nhập!");
            RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("errMessage", "Tạo tài khoản thất bại. Hãy thử lại !!!");
            RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
            rd.forward(request, response);
        }
    }
}
