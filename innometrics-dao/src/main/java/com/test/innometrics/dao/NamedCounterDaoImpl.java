package com.test.innometrics.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.test.innometrics.core.api.dto.NamedCounterDto;
import com.test.innometrics.dao.api.NamedCounterDao;

@Service("NamedCounterDao")
public class NamedCounterDaoImpl implements NamedCounterDao {

	private static final ConcurrentMap<NamedCounterKey, AtomicLong> STORAGE_MAP = new ConcurrentHashMap<NamedCounterKey, AtomicLong>();

	@Override
	public void increment(NamedCounterDto namedCounter) {
		final NamedCounterKey key = new NamedCounterKey(namedCounter.getName());
		AtomicLong previousValue = STORAGE_MAP.putIfAbsent(key, new AtomicLong(1));
		if (previousValue != null) {
			previousValue.incrementAndGet();
		}
	}

	@Override
	public Long getCounterValue(NamedCounterDto namedCounter) {
		final NamedCounterKey key = new NamedCounterKey(namedCounter.getName());
		if (STORAGE_MAP.containsKey(key)) {
			return STORAGE_MAP.get(key).longValue();
		}
		return 0l;
	}

	@Override
	public List<NamedCounterDto> list() {
		Iterator<Entry<NamedCounterKey, AtomicLong>> mapIterator = STORAGE_MAP.entrySet().iterator();
		List<NamedCounterDto> allCounters = new ArrayList<>();
		while (mapIterator.hasNext()) {
			Entry<NamedCounterKey, AtomicLong> mapEntry = mapIterator.next();
			allCounters.add(new NamedCounterDto(mapEntry.getKey().getName(), mapEntry.getValue().get()));
		}
		return allCounters;
	}

}
