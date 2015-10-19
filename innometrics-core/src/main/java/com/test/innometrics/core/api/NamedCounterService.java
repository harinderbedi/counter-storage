package com.test.innometrics.core.api;

import java.util.List;

import com.test.innometrics.core.api.dto.NamedCounterDto;

public interface NamedCounterService {

	String incrementCounter(NamedCounterDto namedCounter);

	NamedCounterDto getCounterValue(NamedCounterDto namedCounter);

	List<NamedCounterDto> list();

}
