package com.tung.ms.exchangeconsume.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tung.ms.exchangeconsume.dto.CurrencyConversionBean;

@FeignClient(name = "exchange-service")
@RibbonClient(name = "exchange-service") // load balancer
public interface CurrencyExchangeServiceProxy {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
