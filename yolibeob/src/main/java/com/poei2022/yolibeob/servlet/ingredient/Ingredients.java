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
import java.util.List;

@WebServlet("/ingredients")
public class Ingredients extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ingredient> ingredientList = DaoFactory.getIngredientDAO().findAll();

        req.setAttribute("ingredients", ingredientList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ingredients.jsp");
        rd.forward(req, resp);
    }

}
