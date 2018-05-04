package com.trace.food.TraceFoodApp.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trace.food.TraceFoodApp.controller.MealController;
import com.trace.food.TraceFoodApp.services.MealService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.Controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;


abstract class WebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

     protected void setMockMvc(Object controller,JUnitRestDocumentation restDocumentation) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).apply(documentationConfiguration(restDocumentation)).build();
    }

}
