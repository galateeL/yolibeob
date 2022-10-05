package com.poei2022.yolibeob.servlet.ingredient;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Ingredient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/addIngredient")
public class AddIngredient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addIngredient.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");

        try {

            DaoFactory.getIngredientDAO().create(new Ingredient(title, null));

        } catch (Exception e){
            e.printStackTrace();

        }

        resp.sendRedirect(req.getContextPath() + "/ingredients");
    }
}
