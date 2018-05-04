package com.trace.food.TraceFoodApp.services;

import com.trace.food.TraceFoodApp.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient getIngredientById(Long ingredientId);

    Ingredient createIngredient(Ingredient ingredient);

    List<Ingredient> getIngredientAll();
}
