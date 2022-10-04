package com.poei2022.yolibeob.servlet;

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

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Recipe> recipes = DaoFactory.getRecipeDAO().findAll();
        request.setAttribute("recipes", recipes);

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

        try {

            int person = Integer.parseInt(personStr);

            Optional userOp = DaoFactory.getUserDAO().findById(Long.parseLong(userId));
            User user = userOp.get();

            //Optional<Ingredient> = DaoFactory.getIngredientDAO.findById()

            DaoFactory.getRecipeDAO().create(new Recipe(title, pictureUrl, time, steps, person, user,null ));

        } catch (Exception e){
            e.printStackTrace();

        }

        resp.sendRedirect(req.getContextPath() + "/recipes");
    }

}
