package com.trace.food.TraceFoodApp.controller;


import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.exceptions.MealsDayNotFoundException;
import com.trace.food.TraceFoodApp.services.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private static Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(method = RequestMethod.GET  , value = "/{ingredientId}")
    public Ingredient getIngredientById(@PathVariable Long ingredientId){
        Ingredient ingredient = this.ingredientService.getIngredientById(ingredientId);
        if(ingredient == null){
            logger.error("Ingredient with id " + ingredientId  + " doesn't exist");
            throw new MealsDayNotFoundException("id -" + ingredientId );
        }
        logger.info("Ingredient with id " + ingredientId + " was founded");
        return ingredient;
    }

    @RequestMapping(method = RequestMethod.POST )
    public Ingredient createIngredient(@RequestBody Ingredient ingredient){
        return this.ingredientService.createIngredient(ingredient);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/all")
    public List<Ingredient> getAllIngredients(){
        return this.ingredientService.getIngredientAll() ;
    }

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

}
