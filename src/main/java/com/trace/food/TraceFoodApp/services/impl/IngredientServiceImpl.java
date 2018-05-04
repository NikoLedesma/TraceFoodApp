package com.trace.food.TraceFoodApp.services.impl;

import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.repositories.IngredientRepository;
import com.trace.food.TraceFoodApp.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository ;

    @Override
    @Transactional
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.findOne(ingredientId);
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getIngredientAll() {
        return ingredientRepository.findAll();
    }

}
