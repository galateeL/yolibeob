package com.poei2022.yolibeob.servlet.user;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =  req.getParameter("email");
        String password =  req.getParameter("password");

        /*MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convertir le tableau de bits en une format hexadécimal - méthode 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }*/

        List<User>users =DaoFactory.getUserDAO().findAll();
        try {
            String message="";
            for (User user : users){
                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                    req.getSession().setAttribute("user",user);
                }else{
                    message = "Connexion failed, wrong email or password !";
                    req.setAttribute("error", message);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/user/login.jsp")
                            .forward(req, resp);
                }

            }

        }catch (Exception e){
            req.setAttribute("error",true);
            doGet(req,resp);
        }


        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
