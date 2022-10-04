package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ingredient_recipe")
public class IngredientRecipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="ingredient_fk")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="recipe_fk")
    private Recipe recipe;

    @Column
    private double quantity;

    @Column
    private String unity;

    public IngredientRecipe() {
    }

    public IngredientRecipe(long id, Ingredient ingredient, Recipe recipe, double quantity, String unity) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.unity = unity;
    }

    public IngredientRecipe(Ingredient ingredient, Recipe recipe, double quantity, String unity) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.unity = unity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
}
