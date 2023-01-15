package me.lunev.homework34.controllers;

import me.lunev.homework34.model.Recipe;
import me.lunev.homework34.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/idIng/{idIng}")
    public ResponseEntity<List<Recipe>> getRecipeOfIdIng(@PathVariable int idIng) {
        List<Recipe> recipesList = new ArrayList<>(recipeService.getRecipeOfIdIng(idIng));
        if (recipesList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipesList);
    }

    @GetMapping("/idIng1/{idIng1}/idIng2/{idIng2}")
    public ResponseEntity<Recipe> getRecipeOfIdIng(@PathVariable int idIng1, @PathVariable int idIng2) {
        Recipe recipe = recipeService.getRecipeOfIdIng2(idIng1, idIng2);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Recipe>> getAllIngredients() {
        Map<Integer, Recipe> listRecipes = recipeService.getAllRecipes();
        if (listRecipes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listRecipes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.editRecipe(id, recipe);
        if (newRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
