package br.com.gabrielga_dev.spring_ai_jokes.controller.api;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Jokes", description = "AI-powered joke generation API")
public interface JokeApi {

    @Operation(
            summary = "Generate a joke",
            description = "Generates a joke using AI based on theme, humor level, and word count",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Joke generated successfully",
                            content = @Content(schema = @Schema(implementation = JokeResponseDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request parameters"
                    )
            }
    )
    ResponseEntity<JokeResponseDTO> generateJoke(
            @Parameter(description = "Joke generation parameters") JokeRequestDTO jokeRequest
    );
}
