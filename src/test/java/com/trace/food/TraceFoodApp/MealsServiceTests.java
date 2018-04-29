package com.trace.food.TraceFoodApp;


import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.entities.MealType;
import com.trace.food.TraceFoodApp.entities.MealsDay;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class MealsServiceTests {

    /*@Autowired
    private MealsDayService mealsDayService;
    private MealsDay mealsDay;
    private Meal meal;
    private Ingredient ingredient;
    private MealType mealType;

    @Before
    public void init(){

        mealsDay = new MealsDay();
        mealsDay.setId(1);
        mealsDay.setRoutineDate(new Date());

        ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("zapallo");
        ingredient.setWeight(3.42f);

        mealType = new MealType();
        mealType.setId(1);
        mealType.setDescription("cualquier cosa");

        meal = new Meal();
        meal.setId(1);
        meal.setDescription("zapallo extremo");
        meal.setInputDateTime(new Date());
        meal.setMealDate(new Date());
        meal.getIngredients().add(ingredient);
        meal.setMealType(mealType);
    }*/
/*
    @Test
    public void testCreateMealsDay() {
        this.mealsDayService.createMealsDay(mealsDay);
    }

    @Test
    public void testAddNewMeal() {
        this.mealsDayService.addNewMeal(mealsDay,meal);
    }
*/
}
