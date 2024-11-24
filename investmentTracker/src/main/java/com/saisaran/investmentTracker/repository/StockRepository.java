package com.saisaran.investmentTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saisaran.investmentTracker.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
