package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cooked_recipe")
public class CookedRecipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String cookDate;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name="recipe_fk")
    private Recipe recipe;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_fk")
    private User user;

    public CookedRecipe() {
    }

    public CookedRecipe(long id, String cookDate, Recipe recipe, User user) {
        this.id = id;
        this.cookDate = cookDate;
        this.recipe = recipe;
        this.user = user;
    }

    public CookedRecipe(String cookDate, Recipe recipe, User user) {
        this.cookDate = cookDate;
        this.recipe = recipe;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCookDate() {
        return cookDate;
    }

    public void setCookDate(String cookDate) {
        this.cookDate = cookDate;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
