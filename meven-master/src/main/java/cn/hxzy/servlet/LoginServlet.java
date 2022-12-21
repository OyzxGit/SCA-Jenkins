package cn.hxzy.servlet;

import cn.hxzy.entity.User;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            User user = userService.login(name, pwd);
            if (user != null) {
                req.getSession().setAttribute("user",user);
                resp.sendRedirect(req.getContextPath() +"/index");
                return;
            }
            req.setAttribute("message", "用户名密码错误");
            req.setAttribute("name", name);
            req.setAttribute("pwd", pwd);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
