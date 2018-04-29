package com.trace.food.TraceFoodApp.services.impl;

import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.entities.MealsDay;
import com.trace.food.TraceFoodApp.repositories.MealsDayRepository;
import com.trace.food.TraceFoodApp.services.MealService;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class MealsDayServiceImpl implements MealsDayService {

    @Autowired
    private MealsDayRepository mealsDayRepository;

    @Autowired
    private MealService mealService;

    @Override
    public MealsDay createMealsDay(MealsDay mealsDay) {
        return this.mealsDayRepository.save(mealsDay);
    }

    @Override
    @Transactional
    public MealsDay addNewMeal(MealsDay mealsDay,Meal meal) {
        //meal = this.mealService.createMeal(meal);
        mealsDay.getMeals().add(meal);
        return this.mealsDayRepository.save(mealsDay);
    }

    @Override
    public MealsDay getMealsDateByRoutineDate(Date routineDate) {
        return this.mealsDayRepository.findByRoutineDateEquals(routineDate);
    }

    @Override
    public MealsDay getMealsDateById(Long mealsDateId) {
        return this.mealsDayRepository.findOne(mealsDateId);
    }

}
