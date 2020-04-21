package pl.coderslab.controller.delete;

import pl.coderslab.dao.UsersGroupsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupDelete", urlPatterns = "/app/admin/groups/delete")
public class GroupDelete extends HttpServlet {
    private UsersGroupsDao usersGroupsDao = new UsersGroupsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("user_group_id"));
        usersGroupsDao.delete(groupId);
        response.sendRedirect("/app/admin/groups");
    }
}
