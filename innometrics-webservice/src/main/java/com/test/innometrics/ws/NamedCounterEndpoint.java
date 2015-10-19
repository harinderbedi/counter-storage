package com.test.innometrics.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.innometrics.core.api.NamedCounterService;
import com.test.innometrics.core.api.dto.NamedCounterDto;

@Component
@Path("/counter")
public class NamedCounterEndpoint {

	@Autowired
	private NamedCounterService service;

	@GET
	@Path("/increment/{name}")
	public String increment(final @PathParam("name") String name) {
		validateParam(name);
		NamedCounterDto namedCounter = new NamedCounterDto(name);
		service.incrementCounter(namedCounter);
		return "SUCCESS";
	}

	@GET
	@Path("/value/{name}")
	public Long value(final @PathParam("name") String name) {
		validateParam(name);
		NamedCounterDto namedCounter = new NamedCounterDto(name);
		NamedCounterDto response = service.getCounterValue(namedCounter);
		return response.getValue();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<NamedCounterDto> list() {
		return service.list();
	}

	private void validateParam(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Parameter 'name' cannot be null");
		} else if (name.length() > 250) {
			throw new IllegalArgumentException("Parameter 'name' cannot be more than 250");
		}
	}

}
