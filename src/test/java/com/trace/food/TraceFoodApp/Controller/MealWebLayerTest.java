package com.trace.food.TraceFoodApp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trace.food.TraceFoodApp.controller.MealController;
import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.entities.Meal;
import com.trace.food.TraceFoodApp.entities.MealType;
import com.trace.food.TraceFoodApp.services.MealService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MealController.class)
@ContextConfiguration(classes = {MealService.class})
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class MealWebLayerTest {


    private Meal meal = null;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    MealService mealService;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/snippets");

    @Before
    public void setup() {
        MealController mealController = new MealController();
        mealController.setMealService(this.mealService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mealController).apply(documentationConfiguration(this.restDocumentation)).build();

        MealType mealType = new MealType();
        mealType.setId(1L);
        mealType.setDescription("desayuno");
        List<Ingredient> ingredients = new ArrayList <Ingredient>();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(12L);
        ingredient.setWeight(34.3F);
        ingredient.setName("meat");
        ingredients.add(ingredient);
        meal = new Meal();
        meal.setId(0L);
        meal.setDescription("milanesa con pure");
        meal.setInputDateTime(new Date());
        meal.setMealDate(new Date());
        meal.setMealType(mealType);
        meal.setIngredients(ingredients);
    }

    @Test
    public void testGetMealByIdMVC() throws Exception{
        when(this.mealService.getMealById(1L)).thenReturn(meal);
        this.mockMvc.perform(get("/meals/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("meals/get"));
    }

    @Test
    public void testCreateMealMVC() throws Exception{
        when(this.mealService.createMeal(meal)).thenReturn(meal);
        this.mockMvc.perform(post("/meals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(meal)))
                .andExpect(status().isOk())
                .andDo(document("meals/create"));
    }


}
