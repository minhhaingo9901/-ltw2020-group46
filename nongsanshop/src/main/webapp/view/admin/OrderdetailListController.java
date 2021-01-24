package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Ordered;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.OrderedService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.OrderedServiceImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listOrderdetail", urlPatterns = "/admin/order/list-detail")
public class OrderdetailListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OrderedService orderedServcie = new OrderedServiceImpl();
    ProductService productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ordered> orderedList = orderedServcie.getAll();
        request.setAttribute("orderedlist", orderedList);
        List<Product> products = new ArrayList<Product>();
        for(Ordered ordered: orderedList)
        {
            Product product = new Product();
            product = productService.get(Integer.parseInt(ordered.getProduct_id()));
            products.add(product);
        }
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-orderdetail.jsp");
        dispatcher.forward(request, response);
    }
}
