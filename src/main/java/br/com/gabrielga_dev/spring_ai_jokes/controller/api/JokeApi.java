package br.com.gabrielga_dev.spring_ai_jokes.controller.api;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;
import org.springframework.http.ResponseEntity;

public interface JokeApi {

    ResponseEntity<JokeResponseDTO> generateJoke(JokeRequestDTO jokeRequest);
}
