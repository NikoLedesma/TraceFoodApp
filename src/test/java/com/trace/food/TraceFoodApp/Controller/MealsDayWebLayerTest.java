package com.trace.food.TraceFoodApp.Controller;


import com.trace.food.TraceFoodApp.controller.MealController;
import com.trace.food.TraceFoodApp.controller.MealsDayController;
import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.entities.MealType;
import com.trace.food.TraceFoodApp.entities.MealsDay;
import com.trace.food.TraceFoodApp.services.MealService;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MealsDayController.class)
@ContextConfiguration(classes = {MealsDayService.class})
public class MealsDayWebLayerTest extends WebLayerTest {

    private MealsDay mealsDay = null;

    @MockBean
    private MealsDayService mealsDayService;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/snippets");


    @Before
    public void init(){
        MealsDayController mealsDayController = new MealsDayController();
        mealsDayController.setMealsDayService(this.mealsDayService);
        super.setMockMvc(mealsDayController,restDocumentation);
        this.createMockMealsDay();
    }

    @Test
    public void testGetMealsDayByIdMVC() throws Exception {
        when(this.mealsDayService.getMealsDateById(1L)).thenReturn(mealsDay);
        this.mockMvc.perform(get("/mealsDay/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("mealsDay/get"));
    }

    @Test
    public void testCreateMealsDayMVC() throws Exception {
        when(this.mealsDayService.createMealsDay(this.mealsDay)).thenReturn(mealsDay);
        this.mockMvc.perform(post("/mealsDay")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mealsDay)))
                .andExpect(status().isOk())
                .andDo(document("mealsDay/create"))
        ;
    }


    private void createMockMealsDay(){
        this.mealsDay = new MealsDay();
        mealsDay.setId(1);
        mealsDay.setRoutineDate(new Date());
        MealType mealType = new MealType();
        mealType.setId(1L);
        mealType.setDescription("desayuno");
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(12L);
        ingredient.setWeight(34.3F);
        ingredient.setName("meat");
        ingredients.add(ingredient);
        Meal meal = new Meal();
        meal.setId(0L);
        meal.setDescription("milanesa con pure");
        meal.setInputDateTime(new Date());
        meal.setMealDate(new Date());
        meal.setMealType(mealType);
        meal.setIngredients(ingredients);
        List<Meal> meals = new ArrayList<Meal>();
        meals.add(meal);
        mealsDay.setMeals(meals);
    }


}
