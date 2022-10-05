package com.poei2022.yolibeob.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String pictureUrl;

   @Column
    private String time;

   @Column
    private String steps;

   @Column
    private int person;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_fk")
    private User user;


    @OneToMany(mappedBy = "recipe" )
    private List<IngredientRecipe> ingredientRecipeList;

   /* @ManyToMany
    private List<Ingredient> ingredientList;*/


    public Recipe() {
    }

    public Recipe(String title, String pictureUrl, String time, String steps, int person, User user, List<IngredientRecipe> ingredientRecipeList) {
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.time = time;
        this.steps = steps;
        this.person = person;
        this.user = user;
        this.ingredientRecipeList = ingredientRecipeList;
    }

    public Recipe(long id, String title, String pictureUrl, String time, String steps, int person, User user, List<IngredientRecipe> ingredientRecipeList) {
        this.id = id;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.time = time;
        this.steps = steps;
        this.person = person;
        this.user = user;
        this.ingredientRecipeList = ingredientRecipeList;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<IngredientRecipe> getIngredientRecipeList() {
        return ingredientRecipeList;
    }

    public void setIngredientRecipeList(List<IngredientRecipe> ingredientRecipeList) {
        this.ingredientRecipeList = ingredientRecipeList;
    }
}
