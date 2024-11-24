package com.saisaran.investmentTracker.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saisaran.investmentTracker.exception.InvalidPanNumberException;
import com.saisaran.investmentTracker.exception.InvestmentNotFoundException;
import com.saisaran.investmentTracker.model.Investment;
import com.saisaran.investmentTracker.repository.InvestmentRepository;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;

    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment createInvestment(Investment investment) {
        validatePanNumber(investment.getPanNumber());
        return investmentRepository.save(investment);
    }

    public Investment getInvestment(Long id) {
        return investmentRepository.findById(id)
                .orElseThrow(() -> new InvestmentNotFoundException("Investment with ID " + id + " not found."));
    }

    public void deleteInvestment(Long id) {
        if (!investmentRepository.existsById(id)) {
            throw new InvestmentNotFoundException("Investment with ID " + id + " not found.");
        }
        investmentRepository.deleteById(id);
    }

    private void validatePanNumber(String panNumber) {
        if (!panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
            throw new InvalidPanNumberException("Invalid PAN number format.");
        }
    }
}
