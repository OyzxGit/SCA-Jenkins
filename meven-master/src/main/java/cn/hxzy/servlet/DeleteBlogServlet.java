package cn.hxzy.servlet;

import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBlog")
public class DeleteBlogServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           String id = req.getParameter("id");
           String userId = req.getParameter("userId");
           Integer i = Integer.parseInt(id);
           blogService.deleteById(i);
           resp.sendRedirect(req.getContextPath()+"userblog?id="+userId);
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
