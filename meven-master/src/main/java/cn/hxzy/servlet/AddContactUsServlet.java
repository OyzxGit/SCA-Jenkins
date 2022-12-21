package cn.hxzy.servlet;

import cn.hxzy.entity.ContactUs;
import cn.hxzy.service.ContactUsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addContactUs")
public class AddContactUsServlet extends HttpServlet {
    ContactUsService contactUsService = new ContactUsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.getRequestDispatcher("/WEB-INF/jsp/other/contact.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String userId = req.getParameter("userId");
            int userid = Integer.parseInt(userId);
            String trueName = req.getParameter("trueName");
            String context = req.getParameter("context");
            String tel = req.getParameter("tel");
            int tel1 = Integer.parseInt(tel);
            ContactUs contactUs = new ContactUs();
            contactUs.setEmail(email);
            contactUs.setUserId(userid);
            contactUs.setTrueName(trueName);
            contactUs.setContext(context);
            contactUs.setTel(tel1);
            contactUsService.add(contactUs);
            resp.sendRedirect(req.getContextPath()+"addContactUs");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
