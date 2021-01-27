package nongsan.webmvc.controller;

import nongsan.webmvc.dao.impl.RegisterDaoImpl;
import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name="RegistrationController", urlPatterns = "/view/client/register")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RegisterDaoImpl registerDao = new RegisterDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


        User user = new User(roleid, email, name, phone, username, password, status, created);

        RegisterDaoImpl register = new RegisterDaoImpl(connectDB.getConnect());
        try {
            if (registerDao.checkRegister(email, phone, username)) {
                // nếu thông tin trùng
                request.setAttribute("errMessage", "Email này đã được đăng ký. Hãy thử lại !!!");
                RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
                rd.forward(request, response);
            } else {
                // nếu thông tin không trùng
                register.RegisterUser(user);
                request.setAttribute("Message", "Tạo tài khoản thành công. Mời bạn đăng nhập!");
                RequestDispatcher rd = request.getRequestDispatcher("/view/client/register.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}