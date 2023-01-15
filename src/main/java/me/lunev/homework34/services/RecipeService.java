package me.lunev.homework34.services;

import me.lunev.homework34.model.Recipe;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(int id);
}
