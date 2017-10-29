package girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlFindOne() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }

}