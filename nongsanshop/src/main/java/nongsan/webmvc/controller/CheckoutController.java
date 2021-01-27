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

@WebServlet(name = "CheckoutController", urlPatterns = "/view/client/checkout")
public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDaoImpl userDao = new UserDaoImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/checkout.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        String name = request.getParameter("transaction_name");
//        String email = request.getParameter("transaction_email");
//        String phone = request.getParameter("transaction_phone");
//        String address = request.getParameter("transaction_address");
//        String mess = request.getParameter("transaction_mess");
//
//        try {
//            if (userDao.orderCheckout(email,name,phone, address,mess)) {
//                request.setAttribute("Message", "Thông tin đơn hàng đã được gửi về email, vui lòng kiểm tra email.");
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
//                rd.forward(request, response);
//            } else {
//                request.setAttribute("errMessage", "Thông tin tài khoản đã nhập sai!");
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
//                rd.forward(request, response);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
