package pl.coderslab.controller.list;

import pl.coderslab.dao.ExercisesDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseList", urlPatterns = "/app/exercises")
public class ExerciseList extends HttpServlet {
    ExercisesDao exercisesDao = new ExercisesDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercise[] exercises = exercisesDao.findAll();
        request.setAttribute("exercises",exercises);
        getServletContext().getRequestDispatcher("/resources/jsp/list/ExerciseList.jsp").forward(request, response);
    }
}
