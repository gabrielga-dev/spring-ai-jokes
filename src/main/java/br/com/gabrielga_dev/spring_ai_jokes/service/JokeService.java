package br.com.gabrielga_dev.spring_ai_jokes.service;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;

public interface JokeService {

    JokeResponseDTO generateJoke(JokeRequestDTO jokeRequest);
}
