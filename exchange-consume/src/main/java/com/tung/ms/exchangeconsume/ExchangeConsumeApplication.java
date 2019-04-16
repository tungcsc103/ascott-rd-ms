package com.tung.ms.exchangeconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.tung.ms.exchangeconsume.proxy")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ExchangeConsumeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExchangeConsumeApplication.class, args);
  }

}
