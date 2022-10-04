package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeDAO {
    List<Recipe> findAll();

    boolean create(Recipe recipe);

    Optional<Recipe> findById(long idParam);

    boolean delete(long id);

    boolean edit(Recipe recipeToEdit);
}
