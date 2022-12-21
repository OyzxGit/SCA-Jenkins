package cn.hxzy.servlet;

import cn.hxzy.entity.Blog;
import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/userblog")
public class UserBlogAllServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String id = req.getParameter("id");
            List<Blog> li =null;
        if (id != null&& id != ""){
       li =blogService.findByUserBlog(Integer.parseInt(id));
        }
            System.out.println(li.toString());
        req.setAttribute("userList",li);
        req.getRequestDispatcher("/WEB-INF/jsp/userBlogAll.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
