package com.example.csstutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TutorialControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void homePageRenders() throws Exception {
        mvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("Learn CSS")));
    }

    @Test
    void flexboxPageRenders() throws Exception {
        mvc.perform(get("/flexbox"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("justify-content")));
    }

    @Test
    void mobilePageRenders() throws Exception {
        mvc.perform(get("/mobile"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("viewport")));
    }

    @Test
    void allPagesReturn200() throws Exception {
        for (String path : new String[]{"/basics", "/box-model", "/flexbox", "/media-queries", "/mobile"}) {
            mvc.perform(get(path)).andExpect(status().isOk());
        }
    }
}
