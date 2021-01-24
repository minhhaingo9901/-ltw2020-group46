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

@WebServlet(name = "editCategory", urlPatterns = "/admin/cate/edit")
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServicesImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Catalog category = new Catalog();
        category.setName(request.getParameter("name"));
        category.setParent_id(request.getParameter("parent-id"));
        category.setId(request.getParameter("id"));
        cateService.edit(category);

        response.sendRedirect(request.getContextPath()+"/admin/cate/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Catalog catelist = cateService.get(Integer.parseInt(id));
        request.setAttribute("catelist", catelist);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editcate.jsp");
        dispatcher.forward(request, response);
    }
}
