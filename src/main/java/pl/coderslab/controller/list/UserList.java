package pl.coderslab.controller.list;

import pl.coderslab.dao.UsersDao;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllUserList", urlPatterns = "/app/users")
public class UserList extends HttpServlet {
    UsersDao usersDao = new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users[] usersList = usersDao.findAll();
        request.setAttribute("usersList",usersList);
        getServletContext().getRequestDispatcher("/resources/jsp/list/AllUsersList.jsp").forward(request, response);
    }
}
