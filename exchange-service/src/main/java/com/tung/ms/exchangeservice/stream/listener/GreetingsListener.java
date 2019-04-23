package com.tung.ms.exchangeservice.stream.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.tung.ms.exchangeservice.dto.Greetings;
import com.tung.ms.exchangeservice.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsListener {

  @StreamListener(GreetingsStreams.INPUT)
  public void handleGreetings(@Payload Greetings greetings) {
    log.info("Received greetings: {}", greetings);
  }
}
