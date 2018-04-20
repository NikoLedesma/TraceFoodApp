package com.trace.food.TraceFoodApp.controller;


import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDishDescription(){
        return "rice";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Meal createDish(@RequestBody Meal meal){
        return this.mealService.createMeal(meal);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/allMeals")
    public List<Meal> getAllDishes(){
        return this.mealService.getAllMeals();
    }

}
