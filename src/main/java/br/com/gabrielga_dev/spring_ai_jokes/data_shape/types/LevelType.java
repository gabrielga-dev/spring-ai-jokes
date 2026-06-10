package br.com.gabrielga_dev.spring_ai_jokes.data_shape.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LevelType {

    NO_FUN_AT_ALL("no-fun"),
    FUN("fun"),
    VERY_FUNNY("very funny");

    private final String value;
}
