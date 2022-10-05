package com.poei2022.yolibeob.servlet.user;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        Optional<User> user = DaoFactory.getUserDAO().findById(Long.parseLong(idStr));
        if (user.isPresent()) {
            req.setAttribute("user", user.get());
            req.getRequestDispatcher("/WEB-INF/user/editUser.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/detailUser");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idUser");
        long id = Long.parseLong(idStr);
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String avatarUrl = req.getParameter("avatarUrl");
        String password = req.getParameter("password");

        try{
            DaoFactory.getUserDAO().edit(new User(id,lastName,firstName,avatarUrl,password));
        }catch (Exception e){
            req.setAttribute("error",true);
            doGet(req,resp);
        }
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
