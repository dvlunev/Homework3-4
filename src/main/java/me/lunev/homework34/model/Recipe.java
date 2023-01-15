package me.lunev.homework34.model;

import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode
public class Recipe {

    private String name;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> cookingSteps;
    private static int number = 1;

    public Recipe() {
    }

    public Recipe(String name, int cookingTime, List<Ingredient> ingredients, List<String> cookingSteps) {
        setName(name);
        setCookingTime(cookingTime);
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNullBlankOrEmpty(name)) {
            name = "Рецепт " + number++;
        }
        this.name = name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime <= 0) {
            cookingTime = 15;
        }
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(List<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }
}
