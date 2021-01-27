package nongsan.webmvc.controller;

import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountUserController",urlPatterns = "/view/client/account")
public class AccountUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDaoImpl userDao= new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            User userinfo = userDao.get(username);
            request.setAttribute("userinfo", userinfo);

        }
           RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/account.jsp");
           dispatcher.forward(request, response);
    }
}
