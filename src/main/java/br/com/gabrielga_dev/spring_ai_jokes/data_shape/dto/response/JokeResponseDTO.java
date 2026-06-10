package br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response;

import java.io.Serializable;

public record JokeResponseDTO(
        String content
) implements Serializable {
}
