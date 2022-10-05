package com.poei2022.yolibeob.servlet;

import com.poei2022.yolibeob.dao.DaoFactory;
import com.poei2022.yolibeob.dao.entity.Ingredient;
import com.poei2022.yolibeob.dao.entity.IngredientRecipe;
import com.poei2022.yolibeob.dao.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/populate")
public class PopulateDatabaseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Recipe> recipeList = new ArrayList<Recipe>();

        Recipe pancakes = new Recipe(
                "Pancakes",
                "https://images.unsplash.com/photo-1528207776546-365bb710ee93?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
                "10 minutes",
                "Mix all the dry ingredients in a bowl.\n" +
                        "Whisk the wet ingredients in a separate bowl, then add the dry ingredients to the wet ones and mix and stir until just combined (do not overmix). My secret: let the batter sit for a minute or two. It will allow the baking powder to activate and make your pancakes fluffy.\n" +
                        "Heat oil or butter in a skillet or griddle and once hot, drop two or three Tablespoons of the batter for each pancake, making sure the pancakes do not spread out. Cook for a minute, until fluffy. Flip, and cook on the other side for another minute. And voilà! Here to some perfect fluffy pancakes in NO TIME!",
                4,
                "Very easy",
                "Low budget",
                "Dessert",
                null,
                null
        );
        recipeList.add(pancakes);

        Recipe smoothie = new Recipe(
                "Raspberry smoothie",
                "https://images.unsplash.com/photo-1570696516188-ade861b84a49?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
                "5 minutes",
                "Step 1\n" +
                        "Combine raspberries, yoghurt and milk in a food processor.\n" +
                        "Step 2\n" +
                        "Step 1\n" +
                        "Combine raspberries, yoghurt and milk in a food processor.\n" +
                        "Step 2\n" +
                        "Process until smooth. Pour over ice, crushed if preferred, between 4 tall glasses to serve. Top with extra raspberries, if you like.",
                2,
                "Very easy",
                "Low budget",
                "Drink",
                null,
                null
        );
        recipeList.add(smoothie);

        Recipe eggsSandwich = new Recipe(
                "Tasty sandwich",
                "https://images.unsplash.com/photo-1627309302198-09a50ae1b209?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                "10 minutes",
                "In a small bowl, combine eggs, onions (if using), mayonnaise, mustard, salt, pepper and garlic powder (if using); stir to combine.\n" +
                        "Place bread slices in pairs on work surface. Spread about ½ cup (125 mL) of egg filling on one of the two slices of bread. Top with a lettuce leaf and the other slice of bread.\n" +
                        "\n" +
                        "Cut each sandwich in half or quarters.",
                2,
                "Very easy",
                "Low budget",
                "Main course",
                null,
                null
        );
        recipeList.add(eggsSandwich);

        Recipe starterSalad = new Recipe(
                "Mixed salad",
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
                "15 minutes",
                "STEP 1\n" +
                        "wine vinegar\n" +
                        "olive oil\n" +
                        "garlic\n" +
                        "grated parmesan cheese\n" +
                        "Prepare the vinaigrette by mixing the wine vinegar, olive oil, crushed garlic and grated parmesan (to taste).\n" +
                        "\n" +
                        "STEP 2\n" +
                        "lamb's lettuce\n" +
                        "rocket\n" +
                        "cherry tomatoes\n" +
                        "chicken\n" +
                        "Add the lamb's lettuce, rocket, cherry tomatoes (cut in half if you prefer) and grilled chicken.\n" +
                        "\n" +
                        "STEP 3\n" +
                        "grated parmesan cheese\n" +
                        "Finish by adding shavings of parmesan cheese.\n",
                4,
                "Very easy",
                "Low budget",
                "Starter",
                null,
                null
        );
        recipeList.add(starterSalad);

    List<Ingredient> ingredients = new ArrayList<Ingredient>();

        Ingredient flower = new Ingredient(
            "Flower"
    );
        ingredients.add(flower);

        Ingredient sugar = new Ingredient(
                "Sugar"
        );
        ingredients.add(sugar);

        Ingredient egg = new Ingredient(
                "Egg"
        );
        ingredients.add(egg);

        Ingredient yeast = new Ingredient(
                "Yeast"
        );
        ingredients.add(yeast);

        Ingredient raspberry = new Ingredient(
                "Raspberry"
        );
        ingredients.add(raspberry);

        Ingredient salad = new Ingredient(
                "Salad"
        );
        ingredients.add(salad);


    List<IngredientRecipe> ingredientRecipeList = new ArrayList<IngredientRecipe>();
        IngredientRecipe ingredientFlower = new IngredientRecipe(
                flower,
                pancakes,
                100,
                "grammes"
        );
        ingredientRecipeList.add(ingredientFlower);

        IngredientRecipe ingredientEgg = new IngredientRecipe(
                egg,
                pancakes,
                3,
                "unity"
        );
        ingredientRecipeList.add(ingredientEgg);

        IngredientRecipe ingredientSugar = new IngredientRecipe(
                sugar,
                pancakes,
                80,
                "grammes"
        );
        ingredientRecipeList.add(ingredientSugar);

        IngredientRecipe ingredientYeast = new IngredientRecipe(
                yeast,
                pancakes,
                10,
                "grammes"
        );
        ingredientRecipeList.add(ingredientYeast);

        IngredientRecipe ingredientRasberry = new IngredientRecipe(
                raspberry,
                smoothie,
                50,
                "grammes"
        );
        ingredientRecipeList.add(ingredientRasberry);

        IngredientRecipe ingredientEgg2 = new IngredientRecipe(
                egg,
                eggsSandwich,
                2,
                "unity"
        );
        ingredientRecipeList.add(ingredientEgg2);

        IngredientRecipe ingredientSalad = new IngredientRecipe(
                salad,
                starterSalad,
                500,
                "grammes"
        );
        ingredientRecipeList.add(ingredientSalad);


        recipeList.forEach(recipe -> {
            DaoFactory.getRecipeDAO().create(recipe);
        });

        ingredients.forEach(ingredient -> {
            DaoFactory.getIngredientDAO().create(ingredient);
        });

        ingredientRecipeList.forEach(i ->
                DaoFactory.getIngredientRecipeDAO().create(i));
    }

}
