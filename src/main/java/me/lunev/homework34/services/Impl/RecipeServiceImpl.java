package me.lunev.homework34.services.Impl;

import me.lunev.homework34.model.Recipe;
import me.lunev.homework34.services.RecipeService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Map<Integer, Recipe> recipes = new HashMap<>();
    private static int id = 1;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipes.put(id++,recipe);
        return recipe;
    }

    @Override
    @Nullable
    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }
}
