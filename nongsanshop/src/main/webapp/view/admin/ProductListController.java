package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listProduct", urlPatterns = "/admin/product/list")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ProductService productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productlist", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-product.jsp");
        dispatcher.forward(request, response);
    }
}
