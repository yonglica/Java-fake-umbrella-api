package com.fake.umbrella;

/*
In Spring Boot, a class that implements CommandLineRunner
is executed after the application is bootstrapped
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
  private MongoTemplate mongoTemplate;

  public ApplicationRunner(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Application has started");
  }

}
