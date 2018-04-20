package com.trace.food.TraceFoodApp.controller;


import com.trace.food.TraceFoodApp.entities.MealsDay;
import com.trace.food.TraceFoodApp.exceptions.MealsDayNotFoundException;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mealsDay")
public class MealsDayController {

    @Autowired
    private MealsDayService mealsDayService;

    @RequestMapping(method = RequestMethod.POST)
    public MealsDay createMealsDate(@RequestBody MealsDay mealsDay){
        return this.mealsDayService.createMealsDay(mealsDay);
    }
/*
    @RequestMapping(method = RequestMethod.GET)
    public MealsDay getMealsDateByRoutineDate(@RequestBody Date routineDate){
        return this.mealsDayService.getMealsDayByRoutineDate(routineDate);
    }*/

    @RequestMapping(method = RequestMethod.GET ,value = "/{mealsDateId}")
    public MealsDay getMealsDateById(@PathVariable Long mealsDateId){
        MealsDay mealsDay = this.mealsDayService.getMealsDateById(mealsDateId);
        if(mealsDay == null){
            throw new MealsDayNotFoundException("id -" + mealsDateId);
        }
        return mealsDay;
    }

}
