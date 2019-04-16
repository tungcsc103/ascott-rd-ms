package com.tung.ms.exchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tung.ms.exchangeservice.entity.ExchangeValue;
import com.tung.ms.exchangeservice.repository.ExchangeValueRepository;

@RestController
public class ForexController {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueRepository repository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

    LOG.info("Start Forex controller");
    ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }

  @GetMapping("/currency-exchange-exception/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValueException(@PathVariable String from, @PathVariable String to) {

    LOG.info("Start Forex controller");
    ExchangeValue exchangeValue = repository.findByFromAndTo(null, "");

    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }
}