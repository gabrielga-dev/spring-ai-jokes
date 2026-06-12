package br.com.gabrielga_dev.spring_ai_jokes.controller;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;
import br.com.gabrielga_dev.spring_ai_jokes.service.JokeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JokeController.class)
class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JokeService jokeService;

    @Test
    void shouldReturn200WhenValidRequest() throws Exception {
        when(jokeService.generateJoke(any(JokeRequestDTO.class)))
                .thenReturn(new JokeResponseDTO("A funny joke!"));

        mockMvc.perform(get("/v1/jokes/generate")
                        .param("theme", "MATH")
                        .param("level", "FUN")
                        .param("wordCount", "50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("A funny joke!"));
    }

    @Test
    void shouldReturn400WhenThemeIsMissing() throws Exception {
        mockMvc.perform(get("/v1/jokes/generate")
                        .param("level", "FUN")
                        .param("wordCount", "50"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenWordCountBelowMin() throws Exception {
        mockMvc.perform(get("/v1/jokes/generate")
                        .param("theme", "MATH")
                        .param("level", "FUN")
                        .param("wordCount", "2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenWordCountAboveMax() throws Exception {
        mockMvc.perform(get("/v1/jokes/generate")
                        .param("theme", "MATH")
                        .param("level", "FUN")
                        .param("wordCount", "1000"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenInvalidThemeValue() throws Exception {
        mockMvc.perform(get("/v1/jokes/generate")
                        .param("theme", "INVALID")
                        .param("level", "FUN")
                        .param("wordCount", "50"))
                .andExpect(status().isBadRequest());
    }
}
