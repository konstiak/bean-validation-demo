package com.example.validation.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ValidationControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void invalidValidation() {
		ValidatedInput input = ValidatedInput.builder()
											 .eMail("invalid @ email.io")
											 .build();
		var response = restTemplate.postForObject("http://localhost:" + port + "/", input, HashMap.class);
		var errors = (List)response.get("errors");

		assertThat(errors).hasSize(1);
		log.info("Response: ", response);
	}

}
