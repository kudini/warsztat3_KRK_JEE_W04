package pl.coderslab.controller.details;

import pl.coderslab.dao.ExercisesDao;
import pl.coderslab.dao.SolutionsDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solutions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseDetails", urlPatterns = "/app/exercise/details")
public class ExerciseDetails extends HttpServlet {
    ExercisesDao exercisesDao = new ExercisesDao();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exercise_id"));
        Exercise exercise = exercisesDao.read(exerciseId);
        request.setAttribute("exercise",exercise);
        getServletContext().getRequestDispatcher("/resources/jsp/details/ExerciseDetails.jsp").forward(request, response);
    }
}
