package nongsan.webmvc.controller;

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

@WebServlet(name = "AccountUserController",urlPatterns = "/view/client/account")
public class AccountUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService= new UserServicesImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String id = request.getParameter("id");
           User useraccount= userService.get(id);
           request.setAttribute("useraccount",useraccount);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/account.jsp");
           dispatcher.forward(request, response);
    }
}
