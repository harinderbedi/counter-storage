package com.test.innometrics.ws;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.test.innometrics.boot.ApplicationBootloader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBootloader.class)
@IntegrationTest("server.port=8080")
@WebAppConfiguration
public class NamedCounterEndpointTest {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void increment() {
		String counterName = "name";
		ResponseEntity<String> response = makeRestCallTo("/counter/increment/" + counterName);
		assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
		assertThat(response.getBody(), Matchers.is("SUCCESS"));
	}

	@Test
	public void getValue() {
		String counterName = "name1909";
		ResponseEntity<String> response = makeRestCallTo("/counter/value/" + counterName);
		assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
		assertThat(response.getBody(), Matchers.is("0"));
	}

	@Test
	public void mustValidateIfCounterNameIsNull() {
		ResponseEntity<String> response = makeRestCallTo("/counter/value/");
		assertThat(response.getStatusCode(), Matchers.is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void mustReturnZeroIfCounterNameDoesNotExist() {
		String counterName = "nameDoesNotExist";
		ResponseEntity<String> response = makeRestCallTo("/counter/value/" + counterName);
		assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
		assertThat(response.getBody(), Matchers.is("0"));
	}

	@Test
	public void incrementAndCheckValue() {
		String counterName = "nameone";
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);

		final ResponseEntity<String> valueResp = makeRestCallTo("/counter/value/" + counterName);
		assertThat(valueResp.getStatusCode(), Matchers.is(HttpStatus.OK));
		assertThat(valueResp.getBody(), Matchers.is("4"));
	}

	@Test
	public void list() {
		String counterName = "nameone_list";
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);
		makeRestCallTo("/counter/increment/" + counterName);

		final ResponseEntity<String> valueResp = makeRestCallTo("/counter/list");
		assertThat(valueResp.getStatusCode(), Matchers.is(HttpStatus.OK));
		assertThat(valueResp.getBody(), Matchers.containsString("{\"name\":\"nameone_list\",\"value\":5}"));
	}

	private ResponseEntity<String> makeRestCallTo(String uri) {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + uri,
				String.class);
		return entity;
	}

}
