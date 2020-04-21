package pl.coderslab.controller.add;

import pl.coderslab.dao.UsersGroupsDao;
import pl.coderslab.model.UsersGroups;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserGroupAdd",urlPatterns = "/app/admin/groups/add")
public class UserGroupAdd extends HttpServlet {
    UsersGroupsDao usersGroupsDao = new UsersGroupsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("group");
        UsersGroups usersGroups = new UsersGroups(name);
        usersGroupsDao.create(usersGroups);
        response.sendRedirect("/app/admin/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/resources/jsp/add/GroupAdd.jsp").forward(request, response);
    }
}
