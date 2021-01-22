package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Transactions;
import nongsan.webmvc.service.TransactionService;
import nongsan.webmvc.service.impl.TransactionServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOrder", urlPatterns = "/admin/order/list")
public class OrderListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TransactionService transactionService = new TransactionServicesImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Transactions> transactionList = transactionService.getAll();
        request.setAttribute("order", transactionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-order.jsp");
        dispatcher.forward(request, response);
    }
}
