package cn.hxzy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if (uri.endsWith(".css") || uri.endsWith(".js")|| uri.endsWith(".png")|| uri.endsWith(".jpg")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            servletRequest.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=UTF-8");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
