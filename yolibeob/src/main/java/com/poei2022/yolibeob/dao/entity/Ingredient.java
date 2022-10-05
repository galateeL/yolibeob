package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "ingredient")
    private List<IngredientRecipe> ingredientRecipeList;

    public Ingredient() {
    }

    public Ingredient(long id, String title, List<IngredientRecipe> ingredientRecipeList) {
        this.id = id;
        this.title = title;
        this.ingredientRecipeList = ingredientRecipeList;
    }

    public Ingredient(String title, List<IngredientRecipe> ingredientRecipeList) {
        this.title = title;
        this.ingredientRecipeList = ingredientRecipeList;
    }

    public Ingredient(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientRecipe> getIngredientRecipeList() {
        return ingredientRecipeList;
    }

    public void setIngredientRecipeList(List<IngredientRecipe> ingredientRecipeList) {
        this.ingredientRecipeList = ingredientRecipeList;
    }
}
