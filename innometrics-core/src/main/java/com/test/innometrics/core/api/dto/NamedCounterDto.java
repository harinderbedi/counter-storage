package com.test.innometrics.core.api.dto;

public class NamedCounterDto {

	private String name;
	private Long value;

	public NamedCounterDto(String name, Long value) {
		this.name = name;
		this.value = value;
	}

	public NamedCounterDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getValue() {
		return value;
	}
}
