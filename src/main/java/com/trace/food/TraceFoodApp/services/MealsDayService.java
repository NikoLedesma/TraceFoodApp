package com.trace.food.TraceFoodApp.services;

import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.entities.MealsDay;

import java.util.Date;

public interface MealsDayService {

    MealsDay createMealsDay(MealsDay mealsDay);

    MealsDay addNewMeal(MealsDay mealsDay,Meal meal);

    MealsDay getMealsDateByRoutineDate(Date routineDate);

    MealsDay getMealsDateById(Long mealsDateId);
}
