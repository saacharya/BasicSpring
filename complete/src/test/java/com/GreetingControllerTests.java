package com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/autoincrease")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Welcome Someone"));
    }

    @Test
    public void paramGreetingCustomMessage() throws Exception {

        this.mockMvc.perform(get("/autoincrease").param("name", "Spock"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Welcome Spock"));
    }

}
