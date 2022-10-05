package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.entity.IngredientRecipe;
import com.poei2022.yolibeob.dao.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface IngredientRecipeDAO {
    List<IngredientRecipe> findAll();

    boolean create(IngredientRecipe ingredientRecipe);

    Optional<IngredientRecipe> findById(long idParam);

    boolean delete(long id);

    List<IngredientRecipe> findByRecipe(Recipe recipe);

    boolean deleteByRecipe(Recipe recipe);
}
