package com.poei2022.yolibeob.servlet;

import com.oracle.wls.shaded.org.apache.bcel.generic.DADD;
import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Ingredient;
import com.poei2022.yolibeob.dao.entity.IngredientRecipe;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/addIngredientToRecipe")
public class AddIngredientToRecipe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ingredient> ingredientList = DaoFactory.getIngredientDAO().findAll();

        String idStr = req.getParameter("id");
        Optional<Recipe> recipe = DaoFactory.getRecipeDAO().findById(Long.parseLong(idStr));

        if (recipe.isPresent()) {

            List<IngredientRecipe> ingredientRecipes = DaoFactory.getIngredientRecipeDAO().findByRecipe(recipe.get());
            req.setAttribute("ingredientsRecipe", ingredientRecipes);

            req.setAttribute("ingredients", ingredientList);
            req.setAttribute("recipe", recipe.get());
            req.getRequestDispatcher("/WEB-INF/addIngredientToRecipe.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/recipes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idRecipe");
        String quantityStr = req.getParameter("quantity");
        String unity = req.getParameter("unity");
        String ingredientName = req.getParameter("ingredientName");

        try {

            double quantity = Double.parseDouble(quantityStr);

           Optional<Ingredient> ingredientOptional = DaoFactory.getIngredientDAO().findByName(ingredientName);
           Optional<Recipe> recipeOptional = DaoFactory.getRecipeDAO().findById(Long.parseLong(idStr));
           if(!recipeOptional.isPresent()) {
               // Erreur
           }
           Ingredient ingredient = null;
            if(!ingredientOptional.isPresent()) {
                ingredient = new Ingredient(ingredientName);
                DaoFactory.getIngredientDAO().create(ingredient);
            }
            else {
                ingredient = ingredientOptional.get();
            }

            IngredientRecipe ingredientRecipe = new IngredientRecipe(ingredient, recipeOptional.get(), quantity, unity);
            DaoFactory.getIngredientRecipeDAO().create(ingredientRecipe);



        } catch(Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/addIngredientToRecipe?id=" + idStr);
    }
}
