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

    @ManyToMany(mappedBy = "ingredientList")
    private List<Recipe> recipeList;

    public Ingredient() {
    }

    public Ingredient(long id, String title, List<Recipe> recipeList) {
        this.id = id;
        this.title = title;
        this.recipeList = recipeList;
    }

    public Ingredient(String title, List<Recipe> recipeList) {
        this.title = title;
        this.recipeList = recipeList;
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

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
