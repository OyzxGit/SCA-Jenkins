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

@WebServlet("/fashion")
public class FashionServlet extends HttpServlet {
    private BlogService blogService = new BlogService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PageObj<Blog> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            String size = req.getParameter("size");
            if (size != null && size != "") {
                pageObj.setPage(Integer.parseInt(size));
            }
            PageObj<Blog> all = blogService.findByIdAll(pageObj, 3);
            System.out.println(all);
            req.setAttribute("PageBlog",all);

            req.getRequestDispatcher("/WEB-INF/jsp/other/fashion.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
