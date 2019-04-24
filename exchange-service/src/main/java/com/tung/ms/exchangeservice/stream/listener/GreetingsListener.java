package com.tung.ms.exchangeservice.stream.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.tung.ms.exchangeservice.dto.Greetings;
import com.tung.ms.exchangeservice.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsListener {

  // TODO support error handling
  @StreamListener(GreetingsStreams.INPUT)
  public void handleGreetings(@Payload Greetings greetings) {
    log.info("Received greetings: {}", greetings);
    throw new RuntimeException("Process message fail");
  }

  @ServiceActivator(inputChannel = "greetings.greetingGroup.errors")
  public void error(Message<?> message) {
    System.out.println("Handling ERROR: " + message);
  }
}
