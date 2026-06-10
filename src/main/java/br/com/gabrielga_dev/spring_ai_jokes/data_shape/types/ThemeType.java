package br.com.gabrielga_dev.spring_ai_jokes.data_shape.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ThemeType {

    GEOGRAPHY("geography"),
    MATH("math"),
    HISTORY("history"),
    CHEMISTRY("chemistry"),
    SOFTWARE_DEVELOPMENT("software development"),
    BIOLOGY("biology");

    private final String value;
}
