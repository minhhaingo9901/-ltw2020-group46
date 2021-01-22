package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Boardnew;
import nongsan.webmvc.service.BoardnewService;
import nongsan.webmvc.service.impl.BoardnewServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editBoardnew",urlPatterns = "/admin/new/edit")
public class BoardnewEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BoardnewService boardnewService = new BoardnewServicesImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Boardnew boardnew = new Boardnew();
        boardnew.setId(request.getParameter("new-id"));
        boardnew.setTitle(request.getParameter("new-title"));
        boardnew.setContent(request.getParameter("new-content"));
        boardnew.setImage_link(request.getParameter("new-image_link"));
        boardnew.setAuthor(request.getParameter("new-author"));
        boardnew.setCreated(request.getParameter("new-created"));
        boardnewService.edit(boardnew);

        response.sendRedirect(request.getContextPath()+"/admin/new/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        request.setAttribute("boardnew", boardnew);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editboardnew.jsp");
        dispatcher.forward(request, response);
    }
}
