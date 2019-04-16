package com.tung.ms.exchangeconsume.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tung.ms.exchangeconsume.dto.CurrencyConversionBean;

@Component
public class CurrencyExchangeServiceProxyFallback implements CurrencyExchangeServiceProxy {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Override
  public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
    LOG.error("Error when call exchange-service. Call fallback");
    return new CurrencyConversionBean();
  }

  @Override
  public CurrencyConversionBean retrieveExchangeValueException(String from, String to) {
    LOG.error("Error when call exchange-service. Call fallback");
    return new CurrencyConversionBean();
  }

}
