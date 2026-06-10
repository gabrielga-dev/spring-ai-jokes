package br.com.gabrielga_dev.spring_ai_jokes.controller;

import br.com.gabrielga_dev.spring_ai_jokes.controller.api.JokeApi;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;
import br.com.gabrielga_dev.spring_ai_jokes.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/jokes")
@RequiredArgsConstructor
public class JokeController implements JokeApi {

    private final JokeService jokeService;

    @Override
    @GetMapping("/generate")
    public ResponseEntity<JokeResponseDTO> generateJoke(JokeRequestDTO jokeRequest) {
        final var generatedJoke = jokeService.generateJoke(jokeRequest);
        return ResponseEntity.ok(generatedJoke);
    }
}
