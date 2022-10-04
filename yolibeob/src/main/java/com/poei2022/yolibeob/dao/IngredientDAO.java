package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientDAO {
    List<Ingredient> findAll();

    boolean create(Ingredient ingredient);

    Optional<Ingredient> findById(long idParam);

    boolean delete(long id);

    boolean edit(Ingredient ingredientToEdit);
}
