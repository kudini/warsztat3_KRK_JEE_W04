package pl.coderslab.controller.delete;

import pl.coderslab.dao.SolutionsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SolutionDelete", urlPatterns = "/app/user/solution/delete")
public class SolutionDelete extends HttpServlet {
    private SolutionsDao solutionsDao = new SolutionsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("solution_id"));
        solutionsDao.delete(userid);
        response.sendRedirect("/app/user/solutions");
    }
}
