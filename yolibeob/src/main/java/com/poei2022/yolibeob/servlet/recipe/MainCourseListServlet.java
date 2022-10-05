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

@WebServlet("/category/main-course")
public class MainCourseListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Recipe> recipeList = DaoFactory.getRecipeDAO().findAll();

        req.setAttribute("recipes", recipeList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mainCourseList.jsp");
        rd.forward(req, resp);
    }
}
