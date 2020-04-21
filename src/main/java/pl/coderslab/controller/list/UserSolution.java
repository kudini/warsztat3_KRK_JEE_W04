package pl.coderslab.controller.list;

import pl.coderslab.dao.SolutionsExerciseUsersDao;
import pl.coderslab.model.SolutionsExerciseUsers;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserSolutions", urlPatterns = "/app/user/solutions")
public class UserSolution extends HttpServlet {
    SolutionsExerciseUsersDao solutionsExerciseUsersDao = new SolutionsExerciseUsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getId();
        SolutionsExerciseUsers[] solutionsExerciseUsers = solutionsExerciseUsersDao.findAllbyUserId(userId);
        request.setAttribute("solutions", solutionsExerciseUsers);
        getServletContext().getRequestDispatcher("/resources/jsp/list/UserSolution.jsp").forward(request, response);
    }
}
