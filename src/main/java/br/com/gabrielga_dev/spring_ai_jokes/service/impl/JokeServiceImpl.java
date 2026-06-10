package br.com.gabrielga_dev.spring_ai_jokes.service.impl;

import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.request.JokeRequestDTO;
import br.com.gabrielga_dev.spring_ai_jokes.data_shape.dto.response.JokeResponseDTO;
import br.com.gabrielga_dev.spring_ai_jokes.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokeServiceImpl implements JokeService {

    private final ChatClient chatClient;

    public static final String PROMPT_FORMAT = """
            Tell me a joke with %d words.
            
            Requirements:
            - theme: %s
            - family friendly
            - level of funniness: %s
            - answer in English
            
            If you think that its impossible to tell a joke with there parameter, answer me with "%s"
            """;
    public static final String ERROR_RESPONSE = "CANT_GENERATE_JOKE";

    @Override
    public JokeResponseDTO generateJoke(JokeRequestDTO jokeRequest) {
        final var prompt = this.buildPrompt(jokeRequest);
        final var aiResponse = chatClient.prompt()
                .user(prompt)
                .call()
                .content();
        if (ERROR_RESPONSE.equals(aiResponse)) {
            return new JokeResponseDTO("Your joke request is boring!");
        }
        return new JokeResponseDTO(aiResponse);
    }

    private String buildPrompt(JokeRequestDTO jokeRequest) {
        return String.format(
                PROMPT_FORMAT,
                jokeRequest.getWordCount(),
                jokeRequest.getTheme().getValue(),
                jokeRequest.getLevel().getValue(),
                ERROR_RESPONSE
        );
    }
}
