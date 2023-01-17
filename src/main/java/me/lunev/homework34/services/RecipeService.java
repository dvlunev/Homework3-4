package me.lunev.homework34.services;

import me.lunev.homework34.model.Recipe;

import java.util.List;
import java.util.Map;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(int id);

    List<Recipe> getRecipeOfIdIng(int idIng);

    Recipe getRecipeOfIdsIng(Integer... idsIng);

    Recipe editRecipe(int id, Recipe recipe);

    boolean deleteRecipe(int id);

    Map<Integer, Recipe> getAllRecipes();

    List<Recipe> getRecipeOfPage(int pageNumber);
}
