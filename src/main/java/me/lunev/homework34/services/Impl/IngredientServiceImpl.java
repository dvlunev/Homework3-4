package me.lunev.homework34.services.Impl;

import me.lunev.homework34.model.Ingredient;
import me.lunev.homework34.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    protected static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    protected static int idIng = 1;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(idIng++,ingredient);
        return ingredient;
    }

    @Override
    public Optional<Ingredient> getIngredient(int id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Optional<Ingredient> editIngredient(int id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(id,ingredient));
    }

    @Override
    public Optional<Ingredient> deleteIngredient(int id) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    @Override
    public Map<Integer, Ingredient> getAllIngredients() {
        return new HashMap<>(ingredients);
    }
}
