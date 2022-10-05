package com.poei2022.yolibeob.servlet;

import com.oracle.wls.shaded.org.apache.bcel.generic.DADD;
import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Ingredient;
import com.poei2022.yolibeob.dao.entity.Recipe;
import com.poei2022.yolibeob.dao.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/auth/addRecipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<Ingredient> ingredientList = DaoFactory.getIngredientDAO().findAll();
       request.setAttribute("ingredients", ingredientList);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addRecipe.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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


        Recipe recipe = null;
        try {

            int person = Integer.parseInt(personStr);

            recipe = new Recipe(
                    title,
                    pictureUrl,
                    time, steps, person, difficulty, budget, criteria, null, null);

            DaoFactory.getRecipeDAO().create(recipe);
        }catch (Exception e){
            req.setAttribute("error",true);
            doGet(req,resp);
        }

        resp.sendRedirect(req.getContextPath() + "/auth/addIngredientToRecipe?id=" + recipe.getId());
    }

}
