package cn.hxzy.servlet;

import cn.hxzy.entity.Blog;
import cn.hxzy.entity.BlogHtml;
import cn.hxzy.entity.Comment;
import cn.hxzy.entity.CommentObj;
import cn.hxzy.service.BlogHtmlService;
import cn.hxzy.service.BlogService;
import cn.hxzy.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/singLePage")
public class SingLePageServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    BlogHtmlService blogHtmlService = new BlogHtmlService();
    CommentService commentService = new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");


            if (id != null && id != ""){
                Blog byId = blogService.findById(Integer.parseInt(id));
                int viewCount = byId.getViewCount();
                viewCount +=1;
                byId.setViewCount(viewCount);
                req.setAttribute("blog",byId);
                Integer blogId = byId.getId();
                BlogHtml htmlById = blogHtmlService.findHtmlById(blogId);
                req.setAttribute("blogHtml",htmlById);

             List<CommentObj> listComment =commentService.findCommentBlogById(blogId);

             req.setAttribute("liComment",listComment);
                System.out.println("liComment"+","+listComment);
                blogService.add(byId);
                req.getRequestDispatcher("/WEB-INF/jsp/other/singlepage.jsp").forward(req,resp);
                return;
            }


            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
