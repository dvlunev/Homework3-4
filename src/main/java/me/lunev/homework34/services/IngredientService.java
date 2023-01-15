package me.lunev.homework34.services;

import me.lunev.homework34.model.Ingredient;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);
}
