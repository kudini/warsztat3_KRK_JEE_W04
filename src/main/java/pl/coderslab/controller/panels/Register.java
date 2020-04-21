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

@WebServlet(name = "Register", urlPatterns = "/register")
public class Register extends HttpServlet {
    UsersDao usersDao = new UsersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int defaultUserGroup= Integer.parseInt(getServletContext().getInitParameter("default-group-id"));
        String username = request.getParameter("username");
        String email = request.getParameter("login");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if(password.equals(repassword)){
            Users tempUser = new Users(username,email,password,defaultUserGroup);
            Users user =usersDao.create(tempUser);
            if (user!=null){
                                response.sendRedirect(request.getContextPath() + "/");
            } else {
                request.setAttribute("message", "Rejestracja nie powiodła się.");
                request.getRequestDispatcher("/resources/jsp/panels/Register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Hasła są różne.");
            request.getRequestDispatcher("/resources/jsp/panels/Register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/resources/jsp/panels/Register.jsp").forward(request, response);
    }
}
