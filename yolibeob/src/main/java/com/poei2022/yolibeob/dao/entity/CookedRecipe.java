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
}
