package com.fake.umbrella;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@SpringBootApplication
public class FakeUmbrellaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FakeUmbrellaApplication.class);

	private final MongoTemplate mongoTemplate;

	public FakeUmbrellaApplication(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application has started");
	}

	public static void main(String[] args) {
		SpringApplication.run(FakeUmbrellaApplication.class, args);
	}

}
