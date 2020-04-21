package pl.coderslab.controller.list;

import pl.coderslab.dao.UsersGroupsDao;
import pl.coderslab.model.UsersGroups;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminGroupsInfo", urlPatterns = "/app/admin/groups")
public class AdminGroupsInfo extends HttpServlet {
    UsersGroupsDao usersDao = new UsersGroupsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersGroups[] usersGroups = usersDao.findAll();
        request.setAttribute("usersGroups", usersGroups);
        getServletContext().getRequestDispatcher("/resources/jsp/list/AdminGroupPage.jsp").forward(request, response);
    }
}
