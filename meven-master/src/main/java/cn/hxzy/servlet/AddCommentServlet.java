package cn.hxzy.servlet;

import cn.hxzy.entity.Comment;
import cn.hxzy.entity.User;
import cn.hxzy.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
    CommentService commentService = new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        String blogId = req.getParameter("blogId");
        if (blogId != null && blogId != "") {
            Comment comment = new Comment();
            String userId = req.getParameter("userId");
            String content = req.getParameter("content");
            String parentId = req.getParameter("parentId");
            if (parentId != null && parentId != ""){
                comment.setParentId(Integer.parseInt(parentId));
            }
            comment.setUserId(Integer.parseInt(userId));
            comment.setBlogId(Integer.parseInt(blogId));
            comment.setContent(content);
            commentService.add(comment);
        }
        resp.sendRedirect(req.getContextPath() +"/singLePage?id="+blogId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
