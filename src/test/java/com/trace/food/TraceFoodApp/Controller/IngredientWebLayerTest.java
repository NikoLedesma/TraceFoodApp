package com.trace.food.TraceFoodApp.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.trace.food.TraceFoodApp.controller.IngredientController;
import com.trace.food.TraceFoodApp.entities.Ingredient;
import com.trace.food.TraceFoodApp.services.IngredientService;
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
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
@ContextConfiguration(classes = {IngredientService.class})
public class IngredientWebLayerTest extends WebLayerTest {

    private List<Ingredient> ingredients;

    @MockBean
    private IngredientService ingredientService;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/snippets");

    @Before
    public void init(){
        IngredientController ingredientController = new IngredientController();
        ingredientController.setIngredientService(this.ingredientService);
        super.setMockMvc(ingredientController,restDocumentation);
        this.createMockIngredient();
    }

    @Test
    public void testCreateIngredientMVC() throws Exception {
        Ingredient ingredientExpected = ingredients.get(0);
        when(this.ingredientService.createIngredient(ingredientExpected)).thenReturn(ingredientExpected);
        this.mockMvc.perform(post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingredientExpected)))
                .andExpect(status().isOk())
                .andDo(document("ingredient/create"));
    }

    @Test
    public void testGetIngredientByIdMVC() throws Exception {
        Ingredient ingredientExpected = ingredients.get(0);
        when(this.ingredientService.getIngredientById(ingredientExpected.getId())).thenReturn(ingredientExpected);
        this.mockMvc.perform(get("/ingredient/"+ingredientExpected.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("ingredient/get"));
    }


    @Test
    public void testGetIngredientAllMVC() throws Exception {
        when(this.ingredientService.getIngredientAll()).thenReturn(ingredients);
        this.mockMvc.perform(get("/ingredient/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("ingredient/getAll"));
    }


    private void createMockIngredient(){
        ingredients = new ArrayList<Ingredient>();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Carne de pollo");
        ingredient.setWeight(5.32f);
        ingredients.add(ingredient);
        ingredient = new Ingredient();
        ingredient.setId(2L);
        ingredient.setName("Tomate");
        ingredient.setWeight(5.32f);
        ingredients.add(ingredient);
    }

}
