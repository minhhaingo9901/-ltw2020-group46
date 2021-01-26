package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
@WebServlet(name = "addProduct", urlPatterns = "/admin/product/add")
public class ProductAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "images";
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

        String filename=uploadImage(request,response);
        product.setImage_link(filename);
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

    public String uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Part filePart = request.getPart("file");
        String fileName="";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
        }

        OutputStream outStream = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            outStream = new FileOutputStream(new File(request.getRealPath("/view/client/assets/images/products/img-test")+ File.separator
                    + fileName));

            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outStream.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + filePart);
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        }
        return fileName;
    }



    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
