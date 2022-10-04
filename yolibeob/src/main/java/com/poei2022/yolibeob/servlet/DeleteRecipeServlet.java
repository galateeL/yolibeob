package com.poei2022.yolibeob.servlet;

import com.oracle.wls.shaded.org.apache.bcel.generic.DADD;
import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/deleteRecipe")
public class DeleteRecipeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRecipeStr = req.getParameter("idRecipe");
        Optional<Recipe> recipeOptional = DaoFactory.getRecipeDAO().findById(Long.parseLong(idRecipeStr));
        DaoFactory.getIngredientRecipeDAO().deleteByRecipe(recipeOptional.get());

        DaoFactory.getRecipeDAO().delete(Long.parseLong(idRecipeStr));

        resp.sendRedirect(req.getContextPath() + "/recipes");

    }
}
