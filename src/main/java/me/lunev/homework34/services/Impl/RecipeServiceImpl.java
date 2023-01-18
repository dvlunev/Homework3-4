package me.lunev.homework34.services.Impl;

import me.lunev.homework34.model.Ingredient;
import me.lunev.homework34.model.Recipe;
import me.lunev.homework34.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.*;

import static me.lunev.homework34.services.Impl.IngredientServiceImpl.ingredients;
import static me.lunev.homework34.services.Impl.IngredientServiceImpl.idIng;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Map<Integer, Recipe> recipes = new HashMap<>();
    private static int id = 1;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if (!ingredients.containsValue(recipe.getIngredients().get(i))) {
                ingredients.put(idIng++,recipe.getIngredients().get(i));
            }
        }
        recipes.put(id++,recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(int id) {
        if (recipes.containsKey(id)) {
            return recipes.get(id);
        }
        return null;
    }

    @Override
    public List<Recipe> getRecipeOfIdIng(int idIng) {
        Ingredient ingredient = ingredients.get(idIng);
        List<Recipe> recipesList = new ArrayList<>();
        for (Recipe recipe : recipes.values()) {
            if (recipe.getIngredients().contains(ingredient)) {
                recipesList.add(recipe);
            }
        }
        return recipesList;
    }

    @Override
    public List<Recipe> getRecipeOfIdsIng(Integer... idsIng) {
        List<Ingredient> ingredientList = new ArrayList<>();
        List<Recipe> recipesList = new ArrayList<>();
        for (int i = 0; i < idsIng.length; i++) {
            ingredientList.add(ingredients.get(idsIng[i]));
        }
        for (Recipe recipe : recipes.values()) {
            if (recipe.getIngredients().containsAll(ingredientList)) {
                recipesList.add(recipe);
            }
        }
        return recipesList;
    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Map<Integer, Recipe> getAllRecipes() {
        return recipes;
    }

    @Override
    public List<Recipe> getRecipeOfPage(int pageNumber) {
        List<Recipe> recipesList = new ArrayList<>();
        for (Integer idRecipe : recipes.keySet()) {
            if (idRecipe > (pageNumber * 10 - 10) && idRecipe <= pageNumber * 10) {
                recipesList.add(recipes.get(idRecipe));
            }
        }
        return recipesList;
    }
}
