package com.saisaran.investmentTracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saisaran.investmentTracker.model.Investment;
import com.saisaran.investmentTracker.service.InvestmentService;

@RestController
@RequestMapping("/investments")
public class InvestmentController {
	
	private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        return ResponseEntity.ok(investmentService.createInvestment(investment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestment(@PathVariable Long id) {
        return ResponseEntity.ok(investmentService.getInvestment(id));
                
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }
	

}
