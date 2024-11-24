package com.saisaran.investmentTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MutualFund {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long mId;

	    private String folioNumber;

	    private String mutualFundName;

	    @ManyToOne
	    @JoinColumn(name = "investment_id")
	    private Investment investment;
	
}
