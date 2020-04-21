package pl.coderslab.controller.add;

import pl.coderslab.dao.SolutionsDao;
import pl.coderslab.model.Solutions;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SolutionAdd", urlPatterns = "/app/user/solution/add")
public class SolutionAdd extends HttpServlet {
    SolutionsDao solutionsDao = new SolutionsDao();
    private int excerciseId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if (users!=null) {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date created = convert(utilDate);
            String description = request.getParameter("solution");
            Solutions solutions = new Solutions(created, created, description, excerciseId, users.getId());
            solutionsDao.create(solutions);
        }
        response.sendRedirect("/app/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        excerciseId = Integer.parseInt(request.getParameter("exercise_id"));
        getServletContext().getRequestDispatcher("/resources/jsp/add/UserSolutionAdd.jsp").forward(request, response);
    }

    public static java.sql.Date convert(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
