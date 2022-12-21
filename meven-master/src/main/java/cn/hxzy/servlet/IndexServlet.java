package cn.hxzy.servlet;

import cn.hxzy.entity.Blog;
import cn.hxzy.entity.BlogHtml;
import cn.hxzy.entity.Resource;
import cn.hxzy.entity.vo.PageObj;
import cn.hxzy.service.BlogHtmlService;
import cn.hxzy.service.BlogService;
import cn.hxzy.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BlogService blogService = new BlogService();
        BlogHtmlService blogHtmlService = new BlogHtmlService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            PageObj<Blog> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            if (page != null && page !=""){
                pageObj.setPage(Integer.parseInt(page));
            }
            String size = req.getParameter("size");
            if (size != null && size != ""){
                pageObj.setPage(Integer.parseInt(size));
            }
            String title = req.getParameter("title");
            PageObj<Blog> all = blogService.findAll(pageObj, title);
            System.out.println(all);
            req.getSession().setAttribute("PageBlog",all);

            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PageObj<Blog> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            if (page != null && page !=""){
                pageObj.setPage(Integer.parseInt(page));
            }
            String size = req.getParameter("size");
            if (size != null && size != ""){
                pageObj.setPage(Integer.parseInt(size));
            }
            String Search = req.getParameter("Search");
            PageObj<Blog> all = blogService.findAll(pageObj, Search);
            System.out.println(all);
            req.getSession().setAttribute("SearchBlog",all);

            req.getRequestDispatcher("/WEB-INF/jsp/searchBlog.jsp").forward(req,resp);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
