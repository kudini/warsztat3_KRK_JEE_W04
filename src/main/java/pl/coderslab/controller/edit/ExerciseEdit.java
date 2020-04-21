package pl.coderslab.controller.edit;

import pl.coderslab.dao.ExercisesDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseEdit", urlPatterns = "/app/admin/exercise/edit")
public class ExerciseEdit extends HttpServlet {
    private ExercisesDao exercisesDao = new ExercisesDao();
    private int exerciseId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exercise exercise = exercisesDao.read(exerciseId);
        exercise.setTitle(title);
        exercise.setDescription(description);
        exercisesDao.update(exercise);
        response.sendRedirect("/app/admin/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        exerciseId = Integer.parseInt(request.getParameter("exercise_id"));
        Exercise exercise = exercisesDao.read(exerciseId);
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/resources/jsp/edit/ExerciseEdit.jsp").forward(request, response);
    }
}
