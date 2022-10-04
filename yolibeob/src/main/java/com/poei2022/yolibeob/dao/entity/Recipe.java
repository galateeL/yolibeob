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

    @ManyToOne(targetEntity = Difficulty.class)
    @JoinColumn(name="difficulty_fk")
    private Difficulty difficulty;

    @ManyToOne(targetEntity = Budget.class)
    @JoinColumn(name="budget_fk")
    private Budget budget;

    @ManyToOne(targetEntity = Criteria.class)
    @JoinColumn(name="criteria_fk")
    private Criteria criteria;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_fk")
    private User user;

    @ManyToMany(mappedBy = "recipeList")
    private List<Ingredient> ingredientList;

    public Recipe() {
    }

    public Recipe(long id, String title, String pictureUrl, String time, String steps, int person, Difficulty difficulty, Budget budget, Criteria criteria, User user, List<Ingredient> ingredientList) {
        this.id = id;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.time = time;
        this.steps = steps;
        this.person = person;
        this.difficulty = difficulty;
        this.budget = budget;
        this.criteria = criteria;
        this.user = user;
        this.ingredientList = ingredientList;
    }

    public Recipe(String title, String pictureUrl, String time, String steps, int person, Difficulty difficulty, Budget budget, Criteria criteria, User user, List<Ingredient> ingredientList) {
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.time = time;
        this.steps = steps;
        this.person = person;
        this.difficulty = difficulty;
        this.budget = budget;
        this.criteria = criteria;
        this.user = user;
        this.ingredientList = ingredientList;
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
