package com.clarivate.test.alliteration.controllers;

import com.clarivate.test.aliteration.AlliterationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AlliterationControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AlliterationService alliterationService;

  @Test
  void getAlliterationMaxPercentageWithNotEmptyText() throws Exception {

    RequestBuilder request =
      MockMvcRequestBuilders
        .post("/alliteration/max")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content("Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.");

    mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().string("y 41.67 %"))
      .andReturn();

  }

  @Test
  void getAllAlliterationPercentagesWithNotEmptyText() throws Exception {

    String expectedResult =
      "y 41.67 %\n" +
        "a 25.00 %\n" +
        "s 8.33 %\n" +
        "h 8.33 %\n" +
        "i 8.33 %\n" +
        "o 8.33 %\n";

    RequestBuilder request =
      MockMvcRequestBuilders
        .post("/alliteration/all")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content("Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.");

    mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().string(expectedResult))
      .andReturn();
  }

  @Test
  void getAlliterationMaxPercentageWithEmptyText() throws Exception {

    RequestBuilder request =
      MockMvcRequestBuilders
        .post("/alliteration/max")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content("");

    mockMvc.perform(request)
      .andExpect(status().isBadRequest())
      .andReturn();
  }

  @Test
  void getAlAlliterationPercentagesOrderedDescWithEmptyText() throws Exception {

    RequestBuilder request =
      MockMvcRequestBuilders
        .post("/alliteration/all")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content("");

    mockMvc.perform(request)
      .andExpect(status().isBadRequest())
      .andReturn();
  }

}

