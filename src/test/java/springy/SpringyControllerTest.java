package springy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringyController.class)
public class SpringyControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SpringyController()).build();
    }

    @Test
    public void getHome() throws Exception {
        this.mockMvc.perform(get("/api/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Greetings from Spring Boot!"));
    }

    @Test
    public void getGreeting() throws Exception {
        this.mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("{\"content\":\"Hello, World!\"}"));
    }

    @Test
    public void getGreetingWithName() throws Exception {
        this.mockMvc.perform(get("/api/greeting?name=sonara"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"content\":\"Hello, sonara!\"}"));
    }

    @Test
    public void postPost() throws Exception {
        this.mockMvc.perform(post("/api/post"))
                .andExpect(status().isOk())
                .andExpect(content().string("You made a post. Congrats!"));
    }
}
