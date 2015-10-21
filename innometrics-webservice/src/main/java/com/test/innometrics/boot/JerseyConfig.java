package com.test.innometrics.boot;

import com.test.innometrics.ws.NamedCounterEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(NamedCounterEndpoint.class);
	}

}
