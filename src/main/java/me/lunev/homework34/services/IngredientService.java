package me.lunev.homework34.services;

import me.lunev.homework34.model.Ingredient;

import java.util.Map;
import java.util.Optional;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);

    Optional<Ingredient> getIngredient(int id);

    Optional<Ingredient> editIngredient(int id, Ingredient ingredient);

    Optional<Ingredient> deleteIngredient(int id);

    Map<Integer, Ingredient> getAllIngredients();
}
