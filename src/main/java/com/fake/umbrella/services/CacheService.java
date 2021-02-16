package com.fake.umbrella.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {

  @Cacheable(cacheNames = "myCache")
  public String cacheThis() {
    log.info("");
    return "this Is it";
  }

}
