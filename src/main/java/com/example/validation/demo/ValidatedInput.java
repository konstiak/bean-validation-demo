package com.example.validation.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.validation.constraints.Email;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidatedInput {

	@Singular("eMail")
	@JsonProperty("eMails")
	private List<@Email String> eMails;
}
