package pl.coderslab.controller.details;

import pl.coderslab.dao.SolutionsDao;
import pl.coderslab.model.Solutions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SolutionDetails", urlPatterns = "/solutions/details")
public class SolutionDetails extends HttpServlet {
    SolutionsDao solutionsDao = new SolutionsDao();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionsID = Integer.parseInt(request.getParameter("solution_id"));
        Solutions solution = solutionsDao.read(solutionsID);
        request.setAttribute("solution",solution);
        getServletContext().getRequestDispatcher("/resources/ExerciseSolution.jsp").forward(request, response);
    }
}
