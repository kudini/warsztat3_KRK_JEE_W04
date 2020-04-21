package pl.coderslab.controller.details;

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

@WebServlet(name = "AllUserDetails", urlPatterns = "/app/users/user")
public class AllUserDetails extends HttpServlet {
    UsersDao usersDao = new UsersDao();
    SolutionsExerciseUsersDao solutionsExerciseUsersDao = new SolutionsExerciseUsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        Users user = usersDao.read(userId);
        SolutionsExerciseUsers[] usersSolutionsList= solutionsExerciseUsersDao.findAllbyId(userId);
        request.setAttribute("solutions",usersSolutionsList);
        request.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/resources/jsp/details/AllUserDetails.jsp").forward(request, response);
    }
}
