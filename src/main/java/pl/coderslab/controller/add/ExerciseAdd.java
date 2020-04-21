package pl.coderslab.controller.add;

import pl.coderslab.dao.ExercisesDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseAdd",urlPatterns = "/app/admin/exercise/add")
public class ExerciseAdd extends HttpServlet {
    private ExercisesDao exercisesDao = new ExercisesDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        exercisesDao.create(new Exercise(title,description));
        response.sendRedirect("/app/admin/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/resources/jsp/add/ExerciseAdd.jsp").forward(request, response);
    }
}
