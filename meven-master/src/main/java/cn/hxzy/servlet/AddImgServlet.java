package cn.hxzy.servlet;

import cn.hxzy.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/addImg")
public class AddImgServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            List<String> li = blogService.findAllImg();
            req.getSession().setAttribute("imglist",li);
            writer.write(li.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
