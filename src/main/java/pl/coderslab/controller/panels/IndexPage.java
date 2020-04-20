package pl.coderslab.controller.panels;

import pl.coderslab.dao.SolutionsExerciseUsersDao;
import pl.coderslab.model.SolutionsExerciseUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexPage",urlPatterns ="/" )
public class IndexPage extends HttpServlet {
    SolutionsExerciseUsersDao solutionsExerciseUsersDao = new SolutionsExerciseUsersDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numberOfSolutions= Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        SolutionsExerciseUsers[] solutionList= solutionsExerciseUsersDao.findRecent(numberOfSolutions);
        request.setAttribute("solutionList",solutionList);
        getServletContext().getRequestDispatcher("/resources/jsp/index/HomePage.jsp").forward(request, response);

    }
}
