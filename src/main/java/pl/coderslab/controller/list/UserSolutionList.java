package pl.coderslab.controller.list;

import pl.coderslab.dao.SolutionsExerciseUsersDao;
import pl.coderslab.dao.UsersDao;
import pl.coderslab.model.SolutionsExerciseUsers;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserSolutionList")
public class UserSolutionList extends HttpServlet {
    SolutionsExerciseUsersDao solutionsExerciseUsersDao = new SolutionsExerciseUsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId=Integer.parseInt(request.getParameter("exercise_id"));;
        SolutionsExerciseUsers[] solutionsExerciseUsers = solutionsExerciseUsersDao.findAllbyExerciseId(exerciseId);
        request.setAttribute("solutions",solutionsExerciseUsers);
        getServletContext().getRequestDispatcher("/resources/jsp/list/AllUsersList.jsp").forward(request, response);
    }
}
