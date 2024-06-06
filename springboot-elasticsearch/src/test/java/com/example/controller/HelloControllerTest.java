package com.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @className: HelloControllerTest
 * @description: TODO 类描述
 * @date: 2023/3/6
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mock;

    @Before
    public void setUp(){

        mock = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void insertShiCiTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/insert").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void SearchTangShiTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/search").contentType(MediaType.APPLICATION_JSON_UTF8).param("keyWord","师")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void SearchHightlightTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/searchHightlight").contentType(MediaType.APPLICATION_JSON_UTF8).param("keyWord","师")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
