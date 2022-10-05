package com.poei2022.yolibeob.servlet.recipe;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/recipe-details")
public class RecipeDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(req.getParameter("id"));

            if(DaoFactory.getRecipeDAO().findById(id).isPresent()){
                Recipe recipe = DaoFactory.getRecipeDAO().findById(id).get();
                req.setAttribute("recipe", recipe);
            } else {
                System.out.println("Recipe not found");
            }

        } catch (NumberFormatException e) {
            req.setAttribute("error_format_id", true);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/recipeDetail.jsp");
        rd.forward(req, resp);
    }
}
