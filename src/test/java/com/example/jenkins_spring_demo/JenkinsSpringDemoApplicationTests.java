package com.example.jenkins_spring_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinsSpringDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void helloShouldReturnExpectedMessage() {
		// Arrange
		JenkinsSpringDemoApplication app = new JenkinsSpringDemoApplication();

		// Act
		String result = app.hello();

		// Assert
		assertEquals(
				"Hello from Jenkins Deploy again one more time after lunch",
				result
		);
	}

}
