package pl.coderslab.controller.delete;

import pl.coderslab.dao.ExercisesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseDelete", urlPatterns = "/app/admin/exercise/delete")
public class ExerciseDelete extends HttpServlet {
    private ExercisesDao exercisesDao = new ExercisesDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exercise_id"));
        exercisesDao.delete(exerciseId);
        response.sendRedirect("/app/admin/exercises");
    }
}
