package br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.LevelType;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.ThemeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JokeRequestDTO {

    private ThemeType theme;
    private LevelType level;
    private Integer wordCount;
}
