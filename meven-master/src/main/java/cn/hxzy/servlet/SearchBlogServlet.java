package cn.hxzy.servlet;

import cn.hxzy.entity.Blog;
import cn.hxzy.entity.vo.PageObj;
import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/Search")
public class SearchBlogServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageObj<Blog> pageObj = new PageObj<>();
        String searchName = req.getParameter("SearchName");
        String page = req.getParameter("page");
        if (page != null && page != ""){
            pageObj.setPage(Integer.parseInt(page));
        }
        String size = req.getParameter("size");
        if (size != null && size != ""){
            pageObj.setSize(Integer.parseInt(size));
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
