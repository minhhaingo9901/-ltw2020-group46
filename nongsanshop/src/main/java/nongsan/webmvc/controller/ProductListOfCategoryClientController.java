package nongsan.webmvc.controller;

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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductListOfCategoryClient", urlPatterns = "/view/client/product-id")
public class ProductListOfCategoryClientController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServicesImpl();
    ProductService productService = new ProductServiceImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);
        String id = request.getParameter("id");
        List<Product> productList = productService.getProductById(Integer.parseInt(id));
        request.setAttribute("productlist", productList);
        //Giá giảm
        List<Product> productsList1 = new ArrayList<Product>();
        for(Product product: productList)
        {
            Product product1 = productService.get(Integer.parseInt(product.getId()));
            product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
            productsList1.add(product1);

        }

        request.setAttribute("productlist1", productsList1);

        // Product bán chạy
        List<Product> product_banchay= productService.getProductById(6);
        request.setAttribute("product_banchay", product_banchay);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/product-cate.jsp");
        dispatcher.forward(request, response);

    }
}
