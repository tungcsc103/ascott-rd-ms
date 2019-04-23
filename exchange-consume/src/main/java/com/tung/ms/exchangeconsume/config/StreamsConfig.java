package com.tung.ms.exchangeconsume.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.tung.ms.exchangeconsume.stream.GreetingsStreams;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {

}
