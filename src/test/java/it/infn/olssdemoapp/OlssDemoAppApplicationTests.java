package it.infn.olssdemoapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OlssDemoAppApplicationTests {


  @Autowired
  private MockMvc mvc;

  @Test
  public void helloApiReturnsGreeting() throws Exception {
    mvc.perform(get("/api/hello"))
      .andExpect(status().isOk())
      .andExpect(content().string(startsWith("Hello world (from")));
  }

  @Test
  public void memoryHogApiReturnsValue() throws Exception {
    mvc.perform(post("/api/memory/grow"))
      .andExpect(status().isOk())
      .andExpect(content().string(is("10000000")));
  }

  @Test
  public void memoryHogClearApiReturnsValue() throws Exception {
    mvc.perform(post("/api/memory/clear"))
      .andExpect(status().isOk())
      .andExpect(content().string(is("0")));
  }

}
