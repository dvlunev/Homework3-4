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

    @GetMapping("/idsIng/{idsIng}")
    public ResponseEntity<List<Recipe>> getRecipeOfIdIng(@PathVariable Integer... idsIng) {
        List<Recipe> recipesList = new ArrayList<>(recipeService.getRecipeOfIdsIng(idsIng));
        if (recipesList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipesList);
    }

    @GetMapping("/pageNumber/{pageNumber}")
    public ResponseEntity<List<Recipe>> getRecipeOfPage(@PathVariable int pageNumber) {
        List<Recipe> recipesList = new ArrayList<>(recipeService.getRecipeOfPage(pageNumber));
        if (recipesList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipesList);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipes() {
        if (recipeService.getAllRecipes() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeService.getAllRecipes());
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
