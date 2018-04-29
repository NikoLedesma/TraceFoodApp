package com.trace.food.TraceFoodApp.Controller;


import com.trace.food.TraceFoodApp.controller.MealController;
import com.trace.food.TraceFoodApp.services.MealService;
import com.trace.food.TraceFoodApp.services.MealsDayService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(MealController.class)
@ContextConfiguration(classes = {MealsDayService.class})
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class MealsDayWebLayerTest {


}
