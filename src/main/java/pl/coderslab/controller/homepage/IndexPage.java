package pl.coderslab.controller.homepage;

import pl.coderslab.dao.SolutionsDao;
import pl.coderslab.dao.SolutionsExerciseUsersDao;
import pl.coderslab.model.Solutions;
import pl.coderslab.model.SolutionsExerciseUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "IndexPage",urlPatterns ="/" )
public class IndexPage extends HttpServlet {
    SolutionsExerciseUsersDao solutionsExerciseUsersDao = new SolutionsExerciseUsersDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numberOfSolutions= Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        SolutionsExerciseUsers[] solutionList= solutionsExerciseUsersDao.findRecent(numberOfSolutions);
        request.setAttribute("solutionList",solutionList);
        getServletContext().getRequestDispatcher("/resources/HomePage.jsp").forward(request, response);

    }
}
