package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.jpa.*;

public class DaoFactory {
    public static CookedRecipeDAO getCookedRecipeDAO() {

        return new JpaCookedRecipeDAO();
    }

    public static IngredientDAO getIngredientDAO(){

        return new JpaIngredientDAO();
    }

    public static RecipeDAO getRecipeDAO() {

        return new JpaRecipeDAO();
    }

    public static UserDAO getUserDAO(){

        return new JpaUserDAO();
    }

    public static IngredientRecipeDAO getIngredientRecipeDAO(){

        return new JpaIngredientRecipeDAO();
    }
}
