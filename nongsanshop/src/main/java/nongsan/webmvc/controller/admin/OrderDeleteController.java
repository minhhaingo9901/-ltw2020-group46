package nongsan.webmvc.controller.admin;

import nongsan.webmvc.service.TransactionService;
import nongsan.webmvc.service.impl.TransactionServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteOrder", urlPatterns = "/admin/order/delete")
public class OrderDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TransactionService transactionService =  new TransactionServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        transactionService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/order/list");
    }
}
