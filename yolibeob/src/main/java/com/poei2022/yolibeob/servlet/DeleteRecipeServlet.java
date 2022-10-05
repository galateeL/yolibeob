package com.poei2022.yolibeob.servlet;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idRecipe");

        try {
            long id = Long.parseLong(idStr);
            req.setAttribute("idRecipe", id);

        } catch (NumberFormatException e) {
            req.setAttribute("error_format_id", true);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/deleteRecipe.jsp");
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRecipeStr = req.getParameter("recipeId");
        try {
            Optional<Recipe> recipeOptional = DaoFactory.getRecipeDAO().findById(Long.parseLong(idRecipeStr));
            DaoFactory.getIngredientRecipeDAO().deleteByRecipe(recipeOptional.get());

            DaoFactory.getRecipeDAO().delete(Long.parseLong(idRecipeStr));

            resp.sendRedirect(req.getContextPath() + "/recipes");

        } catch (NumberFormatException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/deleteRecipe.jsp");
            req.setAttribute("error_format_id", true);
            rd.forward(req, resp);
        }

    }
}
