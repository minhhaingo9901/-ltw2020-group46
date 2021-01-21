package nongsan.webmvc.controller;

import nongsan.webmvc.model.Item;
import nongsan.webmvc.model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "UpdateCart", urlPatterns = "/view/client/cart-update")
public class UpdateCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DecimalFormat df = new DecimalFormat("#.000");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        List<Item> listItems = order.getItems();
        order.setSumPrice(0);
        for(Item item: listItems)
        {
            item.setQty(Integer.parseInt(request.getParameter(item.getProduct().getId())));
            item.setPrice((Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*Double.parseDouble(request.getParameter(item.getProduct().getId())));
            order.setSumPrice(order.getSumPrice() + item.getPrice());
        }
        order.setItems(listItems);
        session.setAttribute("order", order);
        session.setAttribute("sumprice", df.format(order.getSumPrice()));
        response.sendRedirect(request.getContextPath() + "/view/client/cart");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/view/client/cart");
        dispatcher.forward(request, response);
    }
}
