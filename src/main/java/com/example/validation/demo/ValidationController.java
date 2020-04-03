package com.example.validation.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class ValidationController {

	@PostMapping("/")
	public void validate(@RequestBody @Valid ValidatedInput input) {
		log.info("Controller called.", input);
	}
}
