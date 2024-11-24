package com.saisaran.investmentTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saisaran.investmentTracker.model.MutualFund;

public interface MutualFundRepository extends JpaRepository<MutualFund, Long>{

}
