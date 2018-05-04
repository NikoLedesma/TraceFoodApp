package com.trace.food.TraceFoodApp.controller;


import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.exceptions.MealsDayNotFoundException;
import com.trace.food.TraceFoodApp.services.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    private static final Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealService mealService;

    @RequestMapping(method = RequestMethod.GET,value = "/{mealId}")
    public Meal getMealById(@PathVariable Long mealId){
        Meal meal = this.mealService.getMealById(mealId);
        if(meal == null){
            logger.error("Meal with id " + mealId + " doesn't exist");
            throw new MealsDayNotFoundException("id -" + mealId );
        }
        logger.info("Meal with id " + mealId + " was founded");
        return meal;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public Meal createMeal(@RequestBody Meal meal){
        Meal m = this.mealService.createMeal(meal);
        return m;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/allMeals")
    public List<Meal> getAllMeals(){
        return this.mealService.getAllMeals();
    }

    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }

}
