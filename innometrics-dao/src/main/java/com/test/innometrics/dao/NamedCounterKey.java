package com.test.innometrics.dao;

public class NamedCounterKey {

	private String name;

	public NamedCounterKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		NamedCounterKey secondKey = (NamedCounterKey) obj;
		return secondKey.getName().equals(this.name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
