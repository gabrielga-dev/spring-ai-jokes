package br.com.gabrielga_dev.spring_ai_jokes.service.impl;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.LevelType;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.types.ThemeType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.client.ChatClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JokeServiceImplTest {

    @Mock
    private ChatClient chatClient;

    @InjectMocks
    private JokeServiceImpl jokeService;

    @Test
    void shouldReturnJokeWhenAiRespondsSuccessfully() {
        var request = buildRequest();
        String expectedJoke = "Why do programmers prefer dark mode? Because light attracts bugs!";

        var userSpec = mock(ChatClient.ChatClientRequestSpec.class);
        var callResponseSpec = mock(ChatClient.CallResponseSpec.class);

        when(chatClient.prompt()).thenReturn(userSpec);
        when(userSpec.user(anyString())).thenReturn(userSpec);
        when(userSpec.call()).thenReturn(callResponseSpec);
        when(callResponseSpec.content()).thenReturn(expectedJoke);

        var result = jokeService.generateJoke(request);

        assertEquals(expectedJoke, result.content());
    }

    @Test
    void shouldReturnBoringMessageWhenAiCannotGenerateJoke() {
        var request = buildRequest();

        var userSpec = mock(ChatClient.ChatClientRequestSpec.class);
        var callResponseSpec = mock(ChatClient.CallResponseSpec.class);

        when(chatClient.prompt()).thenReturn(userSpec);
        when(userSpec.user(anyString())).thenReturn(userSpec);
        when(userSpec.call()).thenReturn(callResponseSpec);
        when(callResponseSpec.content()).thenReturn(JokeServiceImpl.ERROR_RESPONSE);

        var result = jokeService.generateJoke(request);

        assertEquals("Your joke request is boring!", result.content());
    }

    private JokeRequestDTO buildRequest() {
        var request = new JokeRequestDTO();
        request.setTheme(ThemeType.SOFTWARE_DEVELOPMENT);
        request.setLevel(LevelType.VERY_FUNNY);
        request.setWordCount(50);
        return request;
    }
}
