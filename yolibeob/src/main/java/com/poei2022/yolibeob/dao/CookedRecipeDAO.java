package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.entity.CookedRecipe;

import java.util.List;
import java.util.Optional;

public interface CookedRecipeDAO {

    List<CookedRecipe> findAll();

    boolean create(CookedRecipe cookedRecipe);

    Optional<CookedRecipe> findById(long idParam);

    boolean delete(long id);

    boolean edit(CookedRecipe cookedRecipeToEdit);
}
