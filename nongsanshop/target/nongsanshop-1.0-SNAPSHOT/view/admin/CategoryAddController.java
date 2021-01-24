package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCategory", urlPatterns = "/admin/cate/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServicesImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String cate_name = request.getParameter("cate-name");
        String cate_parent_id = request.getParameter("parent-id");
        Catalog category = new Catalog();
        category.setName(cate_name);
        category.setParent_id(cate_parent_id);
        cateService.insert(category);
        response.sendRedirect(request.getContextPath() + "/admin/cate/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/addcate.jsp");
        dispatcher.forward(request, response);
    }
}
