package cn.hxzy.servlet;

import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collectColl")
public class CollectCollServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String viewCount = req.getParameter("viewCount");
        String blogId = req.getParameter("blogId");
        String userId = req.getParameter("userId");
        String uuserId = req.getParameter("uuserId");
        System.out.println(viewCount);
        System.out.println(blogId);
        System.out.println(viewCount);
        System.out.println(userId);
        System.out.println(uuserId);
        if (userId == uuserId){

        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           String blogId = req.getParameter("blogId1");
           String topCount = req.getParameter("topCount1");
           if (blogId != null && blogId != ""){
               if (topCount != null && topCount != ""){
                   Integer blogId1 = Integer.parseInt(blogId);
                   Integer topCount1 = Integer.parseInt(topCount);
                   topCount1+=1;
                   blogService.updateColl(blogId1,topCount1);
               }

           }
       }catch (Exception e){
           e.printStackTrace();
        }
    }
}
