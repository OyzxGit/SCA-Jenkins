package cn.hxzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/updateUser")
@MultipartConfig
public class UpDataUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        Part file = req.getPart("file");
        PrintWriter writer = resp.getWriter();
        System.out.println(file);
        if (file != null) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = file.getSubmittedFileName();
            String type = fileName.substring(fileName.lastIndexOf("."));
            System.out.println(req.getContextPath());
            System.out.println(req.getServletPath());
            System.out.println(req.getRequestURI());
            System.out.println(req.getSession().getServletContext().getRealPath("/"));
            System.out.println(req.getSession().getServletContext().getRealPath("/") + "images\\" + uuid + type);
            //file.write(req.getSession().getServletContext().getRealPath("/") + "images\\" + uuid + type);
            file.write("E:\\Idea_1\\IdeaProjects\\meven\\src\\main\\webapp\\images\\"+uuid+type);

            writer.write("/images/" + uuid + type);
        }
    }
}
