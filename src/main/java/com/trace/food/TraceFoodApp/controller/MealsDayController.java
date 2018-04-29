package com.trace.food.TraceFoodApp.controller;


import com.trace.food.TraceFoodApp.entities.MealsDay;
import com.trace.food.TraceFoodApp.exceptions.MealsDayNotFoundException;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mealsDay")
public class MealsDayController {

    private static final Logger logger = LoggerFactory.getLogger(MealsDayController.class);

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
            logger.error("Meals Day with id " + mealsDateId + " doesn't exist");
            throw new MealsDayNotFoundException("id -" + mealsDateId);
        }
        logger.info("Meals Day with id " + mealsDateId + " was founded");
        return mealsDay;
    }

}
