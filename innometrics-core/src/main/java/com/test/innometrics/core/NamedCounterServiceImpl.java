package com.test.innometrics.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.innometrics.core.api.NamedCounterService;
import com.test.innometrics.core.api.dto.NamedCounterDto;
import com.test.innometrics.dao.api.NamedCounterDao;

@Service("NamedCounterService")
public class NamedCounterServiceImpl implements NamedCounterService {

	@Autowired
	private NamedCounterDao namedCounterDao;

	@Override
	public String incrementCounter(NamedCounterDto namedCounter) {
		namedCounterDao.increment(namedCounter);
		return "SUCCESS";
	}

	@Override
	public NamedCounterDto getCounterValue(NamedCounterDto namedCounter) {
		String counterName = namedCounter.getName();
		Long counterValue = namedCounterDao.getCounterValue(namedCounter);
		return new NamedCounterDto(counterName, counterValue);
	}

	@Override
	public List<NamedCounterDto> list() {
		return namedCounterDao.list();
	}

}
