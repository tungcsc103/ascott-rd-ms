package com.tung.ms.exchangeconsume.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.tung.ms.exchangeconsume.dto.Greetings;
import com.tung.ms.exchangeconsume.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingsService {

  private final GreetingsStreams greetingsStreams;

  public GreetingsService(GreetingsStreams greetingsStreams) {
    this.greetingsStreams = greetingsStreams;
  }

  public void sendGreeting(final Greetings greetings) {
    log.info("Sending greetings {}", greetings);
    MessageChannel messageChannel = greetingsStreams.outboundGreetings();
    messageChannel.send(MessageBuilder.withPayload(greetings)
        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
  }
}
