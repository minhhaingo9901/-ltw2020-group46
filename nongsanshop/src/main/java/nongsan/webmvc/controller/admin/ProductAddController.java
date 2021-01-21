package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addProduct", urlPatterns = "/admin/product/add")
public class ProductAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String product_cate = request.getParameter("product-cate");
        String product_name = request.getParameter("product-name");
        String product_price = request.getParameter("product-price");
        int product_qty = Integer.parseInt(request.getParameter("product-qty"));
        String product_status = request.getParameter("product-status");
        String product_desc = request.getParameter("product-desc");
        String product_content = request.getParameter("product-content");
        String product_discount = request.getParameter("product-discount");
        String product_image = request.getParameter("product-image");
        String product_day = request.getParameter("product-day");

        Product product = new Product();
        product.setCatalog_id(product_cate);
        product.setName(product_name);
        product.setPrice(product_price);
        product.setQty(product_qty);
        product.setStatus(product_status);
        product.setDescription(product_desc);
        product.setContent(product_content);
        product.setDiscount(product_discount);
        product.setImage_link(product_image);
        product.setCreated(product_day);
        productService.insert(product);
        response.sendRedirect(request.getContextPath() + "/admin/product/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cateService = new CategoryServicesImpl();
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/addproduct.jsp");
        dispatcher.forward(request, response);
    }
}
