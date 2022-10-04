package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.jpa.JpaCookedRecipeDAO;
import com.poei2022.yolibeob.dao.jpa.JpaIngredientDAO;
import com.poei2022.yolibeob.dao.jpa.JpaRecipeDAO;
import com.poei2022.yolibeob.dao.jpa.JpaUserDAO;

public class DaoFactory {
    public static CookedRecipeDAO getCookedRecipeDAO() {
        return new JpaCookedRecipeDAO();
    }

    public static IngredientDAO getIngredientDAO(){

        return new JpaIngredientDAO();
    }

    public static RecipeDAO getIslandDAO() {

        return new JpaRecipeDAO();
    }

    public static UserDAO getUserDAO(){

        return new JpaUserDAO();
    }
}
