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
    void gridPageRenders() throws Exception {
        mvc.perform(get("/grid"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("grid-template-columns")));
    }

    @Test
    void positioningPageRenders() throws Exception {
        mvc.perform(get("/positioning"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("position: sticky")));
    }

    @Test
    void animationsPageRenders() throws Exception {
        mvc.perform(get("/animations"))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.containsString("@keyframes")));
    }

    @Test
    void allPagesReturn200() throws Exception {
        String[] paths = {
            "/basics", "/box-model", "/positioning",
            "/flexbox", "/grid",
            "/media-queries", "/mobile", "/animations"
        };
        for (String path : paths) {
            mvc.perform(get(path)).andExpect(status().isOk());
        }
    }

    @Test
    void everyPageShowsCssSnippet() throws Exception {
        String[] paths = {
            "/basics", "/box-model", "/positioning",
            "/flexbox", "/grid",
            "/media-queries", "/mobile", "/animations"
        };
        for (String path : paths) {
            mvc.perform(get(path))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("<pre><code>")));
        }
    }

    @Test
    void everyPageHasFurtherReading() throws Exception {
        String[] paths = {
            "/", "/basics", "/box-model", "/positioning",
            "/flexbox", "/grid",
            "/media-queries", "/mobile", "/animations"
        };
        for (String path : paths) {
            mvc.perform(get(path))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("references")))
               .andExpect(content().string(org.hamcrest.Matchers.containsString("developer.mozilla.org")));
        }
    }
}
