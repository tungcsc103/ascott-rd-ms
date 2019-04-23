package com.tung.ms.exchangeservice.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.tung.ms.exchangeservice.stream.GreetingsStreams;

@EnableBinding(value = { GreetingsStreams.class })
public class StreamConfig {

}
