package com.example.farmbits.controller;

import com.example.farmbits.model.Category;
import com.example.farmbits.model.Provider;
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
@WebMvcTest(Provider.class)
public class ProviderControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    ProviderController providerController;

    @Test
    public void createTest() throws Exception{
        Provider provider = new Provider(1l,"testProvider","test@email");
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(provider);
        ResultActions response = mvc.perform(post("/api/v1/providers").content(json)
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }

    @Test
    public void findTest() throws Exception{
        ResultActions response = mvc.perform(get("/api/v1/providers"));
        response.andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception{
        Long id = 1l;
        Provider provider = new Provider(1l,"testProvider","test@email");
        ObjectMapper ow =  new ObjectMapper();
        String json = ow.writeValueAsString(provider);
        ResultActions response = mvc.perform(put("/api/v1/providers/?id="+id)
                .contentType(MediaType.APPLICATION_JSON)
        .content(json));
        response.andExpect(status().isOk());

    }

    @Test
    public void deleteTest() throws Exception{
        Long id = 1l;
        ResultActions response = mvc.perform(delete("/api/v1/providers/?id="+id)
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(status().isOk());
    }
}
