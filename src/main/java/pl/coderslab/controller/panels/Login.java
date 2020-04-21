package pl.coderslab.controller.panels;

import pl.coderslab.dao.UsersDao;
import pl.coderslab.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    UsersDao usersDao = new UsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        String username = request.getParameter("login");
        String password = request.getParameter("password");
        Users user = usersDao.read(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                int maxLoginTime‬ = 3600;
                session.setAttribute("isLogged", 1);
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(maxLoginTime‬);
                response.sendRedirect(request.getContextPath() + "/");

            } else {
                request.setAttribute("message", "Błedny użytkownik lub hasło.");
                request.getRequestDispatcher("/resources/jsp/panels/Login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Błedny użytkownik lub hasło.");
            request.getRequestDispatcher("/resources/jsp/panels/Login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/resources/jsp/panels/Login.jsp").forward(request, response);
    }
}
