package com.test.innometrics.core;

import com.test.innometrics.core.api.NamedCounterService;
import com.test.innometrics.core.api.dto.NamedCounterDto;
import com.test.innometrics.dao.api.NamedCounterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NamedCounterService")
public class NamedCounterServiceImpl implements NamedCounterService {

    @Autowired
    private NamedCounterDao namedCounterDao;
    private final String SUCCESS = "SUCCESS";


    @Override
    public String incrementCounter(NamedCounterDto namedCounter) {
        namedCounterDao.increment(namedCounter);
        return SUCCESS;
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
