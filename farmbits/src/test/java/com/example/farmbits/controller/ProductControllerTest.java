package com.example.farmbits.controller;

import com.example.farmbits.model.Category;
import com.example.farmbits.model.Product;
import com.example.farmbits.model.Provider;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Product.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    ProductController productController;

    @Test
    public void createTest() throws Exception {
        Category category = new Category(33l,"testeCategory");
        Provider provider = new Provider(1l,"testProvider","test@email");
        List<Provider> providerList = new ArrayList<>();
        providerList.add(provider);
        Product product = new Product(1l,"testName","testDescription",
                30.0,20.0,category,providerList);
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(product);
        ResultActions response = mvc.perform(post("/api/v1/product").content(json)
        .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());

    }

    @Test
    public void findDiscountTest() throws Exception{
        ResultActions response = mvc.perform(get("/api/v1/product/discount"));
        response.andExpect(status().isOk());
    }

    @Test
    public void findByCategory() throws Exception{
        Long id = 1l;
        ResultActions response = mvc.perform(get("/api/v1/product/category?id="+id));
        response.andExpect(status().isOk());
    }

    @Test
    public void findByProvider() throws Exception{
        Long id = 1l;
        ResultActions response = mvc.perform(get("/api/v1/product/provider?id="+id));
        response.andExpect(status().isOk());
    }
    @Test
    public void editCategoryProduct() throws Exception{
        Long id = 1l;
        Category category = new Category(33l,"testeCategory");
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(category);
        ResultActions response = mvc.perform(put("/api/v1/product/?id="+id).content(json)
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception{
        Long id = 1l;
        ResultActions response = mvc.perform(delete("/api/v1/product/?id="+id));

        response.andExpect(status().isOk());

    }
}
