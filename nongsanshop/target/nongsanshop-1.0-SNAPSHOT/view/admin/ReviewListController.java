package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.Review;
import nongsan.webmvc.service.ReviewService;
import nongsan.webmvc.service.impl.ReviewServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listReview", urlPatterns = "/admin/review/list")
public class ReviewListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ReviewService reviewService = new ReviewServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Review> reviewList = reviewService.getAll();
        request.setAttribute("reviewlist", reviewList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-review.jsp");
        dispatcher.forward(request, response);
    }
}
