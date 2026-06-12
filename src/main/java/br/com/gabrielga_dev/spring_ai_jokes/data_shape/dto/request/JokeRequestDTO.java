package br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.LevelType;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.ThemeType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JokeRequestDTO {

    @NotNull(message = "Theme is required")
    private ThemeType theme;

    @NotNull(message = "Level is required")
    private LevelType level;

    @NotNull(message = "Word count is required")
    @Min(value = 5, message = "Word count must be at least 5")
    @Max(value = 500, message = "Word count must be at most 500")
    private Integer wordCount;
}
