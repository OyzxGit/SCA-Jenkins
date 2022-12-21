package cn.hxzy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String url = request.getRequestURI();
            if (url.endsWith("login") || url.endsWith("logout") || url.endsWith(".jsp") ||url.endsWith("register")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jpg")||url.endsWith(".png")||url.endsWith("updateUser")||url.endsWith("addImg")){
                filterChain.doFilter(servletRequest,servletResponse);
            return;
            }
        Object user = request.getSession().getAttribute("user");
            if (user != null){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        response.sendRedirect(request.getContextPath() +"login");
    }

    @Override
    public void destroy() {

    }
}
