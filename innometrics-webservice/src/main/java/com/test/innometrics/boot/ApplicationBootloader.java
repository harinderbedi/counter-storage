package com.test.innometrics.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.test.innometrics" })
public class ApplicationBootloader extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationBootloader.class);
	}

	public static void main(String[] args) {
		new ApplicationBootloader().configure(new SpringApplicationBuilder(ApplicationBootloader.class)).run(args);
	}
}
