package me.lunev.homework34.services.Impl;

import me.lunev.homework34.model.Ingredient;
import me.lunev.homework34.model.Recipe;
import me.lunev.homework34.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Recipe getRecipeOfIdIng2(int idIng1, int idIng2) {
        Ingredient ingredient1 = ingredients.get(idIng1);
        Ingredient ingredient2 = ingredients.get(idIng2);
        for (Recipe recipe : recipes.values()) {
            if (recipe.getIngredients().contains(ingredient1) && recipe.getIngredients().contains(ingredient2)) {
                return recipe;
            }
        }
        return null;
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
        return new HashMap<>(recipes);
    }
}
