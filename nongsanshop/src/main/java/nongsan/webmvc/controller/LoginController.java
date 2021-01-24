package nongsan.webmvc.controller;

import nongsan.webmvc.dao.impl.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="ClientLogin", urlPatterns = "/view/client/login")
public class LoginController extends HttpServlet {
    private UserDaoImpl userDAO = new UserDaoImpl();
    private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/login.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int roleid = Integer.parseInt(request.getParameter("roleid"));
        int status = Integer.parseInt(request.getParameter("status"));
        try {
            if (userDAO.checkLogin(username, password, roleid, status)) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/");
                System.out.println(username);
            } else if (userDAO.checkLogin1(username, password, roleid, status)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/admin/homepage");
                System.out.println(username);
            } else {
                request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/login.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
