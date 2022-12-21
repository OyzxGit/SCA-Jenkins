package cn.hxzy.servlet;

import cn.hxzy.entity.Blog;
import cn.hxzy.entity.BlogHtml;
import cn.hxzy.service.BlogHtmlService;
import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/editBlog")

public class EditBlogServlet extends HttpServlet {
    BlogHtmlService blogHService =new BlogHtmlService();
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String id = req.getParameter("id");
            if (id != null && id != "") {
                Blog byId = blogService.findById(Integer.parseInt(id));

                req.setAttribute("blog", byId);

                BlogHtml blogH = blogHService.findHtmlById(Integer.parseInt(id));

                req.setAttribute("bolgHtml", blogH);

            }
        req.getRequestDispatcher("/WEB-INF/jsp/blogEdit.jsp").forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String id = req.getParameter("id");
        BlogHtml blogHtml = new BlogHtml();
        Blog blog = new Blog();
        if (id != null && id != ""){
            blog.setId(Integer.parseInt(id));

        }
        String title = req.getParameter("title");
        String info = req.getParameter("info");
        String categoriesId = req.getParameter("categoriesId");
            String image = req.getParameter("image");
            String userId = req.getParameter("userId");
            if(userId != null && userId !="") {
                blog.setUserId(Integer.parseInt(userId));
            }
            blog.setTitle(title);
        blog.setInfo(info);
        blog.setCategoriesId(Integer.parseInt(categoriesId));
        blog.setImage(image);
            Integer blogId = blogService.add(blog);

            String html = req.getParameter("html");
            blogHtml.setHtml(html);
            if (id != null && id != ""){
                String htmlId = req.getParameter("HtmlId");
                blogHtml.setId(Integer.parseInt(htmlId));
                blogHtml.setBlog_id(Integer.parseInt(id));
                blogHService.update(blogHtml);

            }else {
                blogHtml.setBlog_id(blogId);
                blogHService.add(blogHtml);
//                resp.sendRedirect(req.getContextPath() +"/index");
            }
            resp.sendRedirect(req.getContextPath() +"/userblog?id="+userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
