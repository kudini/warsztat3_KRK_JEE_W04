package pl.coderslab.controller.edit;

import pl.coderslab.dao.UsersGroupsDao;
import pl.coderslab.model.UsersGroups;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupEdit", urlPatterns = "/app/admin/groups/edit")
public class GroupEdit extends HttpServlet {
    private UsersGroupsDao usersGroupsDao = new UsersGroupsDao();
    private int userGroupId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("group");
        UsersGroups usersGroups = usersGroupsDao.read(userGroupId);
        usersGroups.setName(name);
        usersGroupsDao.update(usersGroups);
        response.sendRedirect("/app/admin/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userGroupId = Integer.parseInt(request.getParameter("user_group_id"));
        UsersGroups usersGroups = usersGroupsDao.read(userGroupId);
        request.setAttribute("usersGroups", usersGroups);
        getServletContext().getRequestDispatcher("/resources/jsp/edit/GroupEdit.jsp").forward(request, response);
    }
}
