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

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			NamedCounterDto secondObject = (NamedCounterDto) obj;
			if (secondObject.getName().equalsIgnoreCase(this.name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
