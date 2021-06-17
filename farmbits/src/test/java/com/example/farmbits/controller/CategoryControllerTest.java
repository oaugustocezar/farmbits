package com.example.farmbits.controller;

import com.example.farmbits.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Category.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryController categoryController;

    @Test
    public void findTest() throws Exception{
        ResultActions response = mvc.perform(get("/api/v1/category"));
        response.andExpect(status().isOk());
    }

    @Test
    public void postCategory() throws Exception{
        Category category = new Category(1l,"testeCategory");
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(category);
        ResultActions response = mvc.perform(post("/api/v1/category").content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE));
        response.andExpect(status().isOk());
    }

    @Test
    public void putCategory() throws Exception{
        Category category = new Category(1l,"testeCategory");
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(category);
        Long id = 1l;
        ResultActions response = mvc.perform(put("/api/v1/category?id="+id)
                .contentType(MediaType.APPLICATION_JSON).content(json));
                response.andExpect(status().isOk());

    }




}
