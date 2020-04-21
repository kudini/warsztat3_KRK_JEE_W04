package pl.coderslab.controller.delete;

import pl.coderslab.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDelete", urlPatterns = "/app/admin/users/delete")
public class UserDelete extends HttpServlet {
    private UsersDao usersDao = new UsersDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        usersDao.delete(userid);
        response.sendRedirect("/app/admin/users");
    }
}
