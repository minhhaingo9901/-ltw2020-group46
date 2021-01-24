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

@WebServlet(name = "editProduct", urlPatterns = "/admin/product/edit")
public class ProductEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Product product = new Product();
        product.setId(request.getParameter("product-sku"));
        product.setCatalog_id(request.getParameter("product-cate"));
        product.setName(request.getParameter("product-name"));
        product.setPrice(request.getParameter("product-price"));
        product.setQty(Integer.parseInt(request.getParameter("product-qty")));
        product.setStatus(request.getParameter("product-status"));
        product.setDescription(request.getParameter("product-desc"));
        product.setContent(request.getParameter("product-content"));
        product.setDiscount(request.getParameter("product-discount"));
        product.setImage_link(request.getParameter("product-image"));
        product.setCreated(request.getParameter("product-day"));
        productService.edit(product);

        response.sendRedirect(request.getContextPath()+"/admin/product/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cateService = new CategoryServicesImpl();
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);

        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editproduct.jsp");
        dispatcher.forward(request, response);
    }
}
