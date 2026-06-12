package br.com.gabrielga_dev.spring_ai_jokes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SpringAiJokesApplicationTests {

	@Test
	void mainMethodShouldExist() {
		assertDoesNotThrow(() -> SpringAiJokesApplication.class.getDeclaredMethod("main", String[].class));
	}
}
