package pl.coderslab.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "IsLogged", urlPatterns = "/app/*")
public class IsLogged implements javax.servlet.Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);

        HttpSession session = request.getSession();

        Object logged = session.getAttribute("isLogged");
        boolean isLogged = logged != null;
        if (isLogged) {
            chain.doFilter(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
