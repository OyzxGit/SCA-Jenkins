package cn.hxzy.servlet;

import cn.hxzy.entity.User;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userUpdate")
public class userUpdateServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp").forward(req,resp);
        //resp.sendRedirect("/WEB-INF/jsp/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                String id = req.getParameter("id");
                User user = new User();
                String loginName = req.getParameter("loginName");
                if (loginName != null && loginName != "") {
                    user.setLoginName(loginName);
                }
                String loginPassword = req.getParameter("loginPassword");
                if (loginPassword != null && loginPassword != "") {
                    user.setLoginPassword(loginPassword);
                }
                    String true_name = req.getParameter("trueName");
                    if (true_name != null && true_name != "") {
                        user.setTrueName(true_name);
                    }
                    String img = req.getParameter("img");
                    if (img != null && img != "") {
                        user.setImg(img);
                    }
                    String tel = req.getParameter("tel");
                    if (tel != null && tel != "") {
                        user.setTel(Integer.parseInt(tel));
                    }
                    String card = req.getParameter("card");
                    if (card != null && card != "") {
                        user.setCard(card);
                    }
                    String email = req.getParameter("Email");
                    if (email != null && email != "") {
                        user.setEmail(email);
                    }
                    String info = req.getParameter("info");
                    if (info != null && info != "") {
                        user.setInfo(info);
                    }

                if (id != null && id != "") {
                    user.setId(Integer.parseInt(id));
                    userService.update(user);
                    resp.sendRedirect(req.getContextPath() + "/index");
                }
               // resp.sendRedirect(req.getContextPath() + "/userblog");
               // req.setAttribute("message", "你输入的信息有误");
              //  req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,resp);

            }catch (Exception e){
                    e.printStackTrace();
            }



    }
}
