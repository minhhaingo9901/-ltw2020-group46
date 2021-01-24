package nongsan.webmvc.controller;

import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ForgotPasswordController", urlPatterns = "/view/client/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private UserDaoImpl userDAO = new UserDaoImpl();
    private static final long serialVersionUID = 1L;
    public ForgotPasswordController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        User user = new User();
        try {
            if (userDAO.passwordRecovery(email)) {
                request.setAttribute("Message", "Mật khẩu đã được gửi, vui lòng kiểm tra email và đăng nhập lại!.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("errMessage", "Tài khoản không tồn tại với email này!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
