package com.poei2022.yolibeob.servlet.user;

import com.poei2022.yolibeob.dao.DaoFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUserStr = req.getParameter("idUser");
        DaoFactory.getUserDAO().delete(Long.parseLong(idUserStr));
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
