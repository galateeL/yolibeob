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

@WebServlet("/auth/detailUser")
public class UserDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        long id = Long.parseLong(idStr);
        Optional<User> userOptional = DaoFactory.getUserDAO().findById(id);
        req.setAttribute("user", userOptional.get());
        req.getRequestDispatcher("/WEB-INF/user/detailUser.jsp").forward(req, resp);
    }
}
