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
import java.util.List;

@WebServlet(name = "listBoardnew", urlPatterns = "/admin/new/list")
public class BoardnewListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BoardnewService newService = new BoardnewServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Boardnew> boardnewList = newService.getAll();
        request.setAttribute("boardnewlist", boardnewList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-new.jsp");
        dispatcher.forward(request, response);
    }
}
