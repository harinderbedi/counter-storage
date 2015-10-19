package com.test.innometrics.dao.api;

import java.util.List;

import com.test.innometrics.core.api.dto.NamedCounterDto;

public interface NamedCounterDao {

	void increment(NamedCounterDto namedCounter);

	Long getCounterValue(NamedCounterDto namedCounter);

	List<NamedCounterDto> list();

}
