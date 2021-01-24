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
        product.setImage_link(uploadFile(request));
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
    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("product-image");

            //fileName: picture-001.jpg
            fileName = (String) getFileName(filePart);

            //applicationPath: C:\Users\Lonely\Documents\NetBeansProjects\Shop_Bonfire\build\web
            String applicationPath = request.getServletContext().getRealPath("");

            //File.separator: \
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;

            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;

    }
}
