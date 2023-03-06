package com.returners.apiLab.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {


    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testCoffeeLover() throws Exception {
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string (expectedContent));
    }

    @Test
    public void testGetCoffeeWithoutRequestParams() throws Exception {
        String expectedValue = "Cortado";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").
                        value(expectedValue));
    }


    @Test
    public void testGetCoffeeWithRequestParams() throws Exception {
        String expectedValue = "Cappuccino";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee").param("name",
                                "Cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").
                        value(expectedValue));
    }

//    @Test
//    public void testGetAllCoffeeTypes() throws Exception {
//         this.mockMvcController.perform(
//                        MockMvcRequestBuilders.get("/coffee").param("name",
//                                "Cappuccino"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(jsonPath("$", hasSize(14)));
//    }




}
