package com.trace.food.TraceFoodApp.services.impl;

import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.repositories.MealReposity;
import com.trace.food.TraceFoodApp.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {


    @Autowired
    private MealReposity dishReposity;

    @Override
    public Meal createMeal(Meal meal) {
       return this.dishReposity.save(meal);
    }

    @Override
    public List<Meal> getAllMeals() {
        return this.dishReposity.findAll();
    }

}
