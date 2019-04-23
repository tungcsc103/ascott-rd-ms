package com.tung.ms.exchangeconsume.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GreetingsStreams {
  String OUTPUT = "greetings-out";

  @Output(OUTPUT)
  MessageChannel outboundGreetings();
}