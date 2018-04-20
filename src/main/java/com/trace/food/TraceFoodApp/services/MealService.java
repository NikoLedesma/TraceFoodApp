package com.trace.food.TraceFoodApp.services;

import com.trace.food.TraceFoodApp.entities.Meal;

import java.util.List;

public interface MealService {

    Meal createMeal(Meal meal);

    List<Meal> getAllMeals();

}
