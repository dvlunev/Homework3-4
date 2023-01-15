package me.lunev.homework34.services.Impl;

import me.lunev.homework34.model.Ingredient;
import me.lunev.homework34.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    private static int id = 1;


    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id++,ingredient);
        return ingredient;
    }

    @Override
    public Ingredient getIngredient(int id) {
        return ingredients.get(id);
    }
}
