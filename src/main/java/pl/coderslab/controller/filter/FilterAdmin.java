package pl.coderslab.controller.filter;

import pl.coderslab.model.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "FilterAdmin", urlPatterns = "/app/admin/*")
public class FilterAdmin implements Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        int adminGroup = Integer.parseInt(request.getServletContext().getInitParameter("admin-group-id"));


        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);

        HttpSession session = request.getSession();

        Users user = (Users) session.getAttribute("user");
        boolean isAdmin = user.getUserGroupId() == adminGroup;
        if (isAdmin) {
            chain.doFilter(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
