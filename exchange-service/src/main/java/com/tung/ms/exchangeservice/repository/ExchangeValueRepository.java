package com.tung.ms.exchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tung.ms.exchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
  ExchangeValue findByFromAndTo(String from, String to);
}