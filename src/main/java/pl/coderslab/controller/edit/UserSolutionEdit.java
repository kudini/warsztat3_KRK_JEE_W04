package pl.coderslab.controller.edit;

import pl.coderslab.dao.SolutionsDao;
import pl.coderslab.model.Solutions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static pl.coderslab.controller.add.SolutionAdd.convert;

@WebServlet(name = "UserSolutionEdit", urlPatterns = "/app/solutions/edit")
public class UserSolutionEdit extends HttpServlet {
    private SolutionsDao solutionsDao = new SolutionsDao();
    private int solutionId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date updated = convert(utilDate);
        Solutions solution = solutionsDao.read(solutionId);
        solution.setDescription(description);
        solution.setUpdated(updated);
        solutionsDao.update(solution);
        response.sendRedirect("/app/user/solutions");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        solutionId = Integer.parseInt(request.getParameter("solution_id"));
        Solutions solution = solutionsDao.read(solutionId);
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/resources/jsp/edit/SolutionEdit.jsp").forward(request, response);
    }
}
