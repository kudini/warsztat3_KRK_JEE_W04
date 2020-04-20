package pl.coderslab.controller.list;

import pl.coderslab.dao.UsersDao;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserGroupList", urlPatterns = "/groups/group")
public class UserGroupList extends HttpServlet {
    UsersDao usersDao = new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userGroupId = Integer.parseInt(request.getParameter("user_group_id"));
        String groupName = request.getParameter("group_name");
        request.setAttribute("groupName", groupName);
        Users[] usersList = usersDao.findAllbyId(userGroupId);
        request.setAttribute("usersList",usersList);
        getServletContext().getRequestDispatcher("/resources/GroupUserPage.jsp").forward(request, response);
    }
}
