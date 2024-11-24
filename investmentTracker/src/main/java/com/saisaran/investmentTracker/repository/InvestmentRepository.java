package com.saisaran.investmentTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saisaran.investmentTracker.model.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
	

}
