package pl.coderslab.controller.edit;

import pl.coderslab.dao.UsersDao;
import pl.coderslab.dao.UsersGroupsDao;
import pl.coderslab.model.Users;
import pl.coderslab.model.UsersGroups;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEdit", urlPatterns = "/app/admin/users/edit")
public class UserEdit extends HttpServlet {
    private UsersGroupsDao usersGroupsDao = new UsersGroupsDao();
    private UsersDao userDao = new UsersDao();
    private int userid;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String groupId = request.getParameter("user_group_id");
        System.out.println(groupId);
        Users user = userDao.read(userid);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserGroupId(Integer.parseInt(groupId));
        userDao.update(user);
        response.sendRedirect("/app/admin/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userid = Integer.parseInt(request.getParameter("user_id"));
        Users user = userDao.read(userid);
        UsersGroups[] groups = usersGroupsDao.findAll();
        request.setAttribute("user", user);
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/resources/jsp/edit/UserEdit.jsp").forward(request, response);
    }
}
