package com.poei2022.yolibeob.servlet;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Ingredient;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/editRecipe")
public class EditRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ingredient> ingredientList = DaoFactory.getIngredientDAO().findAll();

        String idStr = req.getParameter("id");
        Optional<Recipe> recipe = DaoFactory.getRecipeDAO().findById(Long.parseLong(idStr));

        if (recipe.isPresent()) {
            req.setAttribute("ingredients", ingredientList);
            req.setAttribute("recipe", recipe.get());
            req.getRequestDispatcher("/WEB-INF/editRecipe.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/recipes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idRecipe");

        String title = req.getParameter("title");
        String pictureUrl = req.getParameter("pictureUrl");
        String time = req.getParameter("time");
        String steps = req.getParameter("steps");
        String personStr = req.getParameter("person");
        String userId = req.getParameter("user");
        String ingredients = req.getParameter("ingredient");

        String difficulty = req.getParameter("difficulty");
        String budget = req.getParameter("budget");
        String criteria = req.getParameter("criteria");



        String ingredientId = req.getParameter("ingredientId");

        try {

            int person = Integer.parseInt(personStr);

            Optional<Ingredient> optionalIngredient = DaoFactory.getIngredientDAO().findById(Long.parseLong(ingredientId));
            Ingredient ingredient = optionalIngredient.get();

            DaoFactory.getRecipeDAO().edit(new Recipe(title, pictureUrl, time, steps,person, difficulty, budget, criteria,null, null));


        } catch(Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/recipes");
    }
}
