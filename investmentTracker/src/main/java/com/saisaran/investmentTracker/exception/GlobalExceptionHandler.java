package com.saisaran.investmentTracker.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPanNumberException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidPanNumber(InvalidPanNumberException ex) {
    	Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Not Found");
        response.put("message", ex.getMessage());
        System.out.println("Response iss   ::: "+response);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
       
    }
    

    @ExceptionHandler(InvestmentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleInvestmentNotFound(InvestmentNotFoundException ex) {
    	Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Not Found");
        response.put("message", ex.getMessage());
        System.out.println("Response iss   ::: "+response);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
