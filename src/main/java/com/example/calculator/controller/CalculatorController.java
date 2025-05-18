package com.example.calculator.controller;

import com.example.calculator.model.CalculationRequest;
import com.example.calculator.model.CalculationResult;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
@CrossOrigin(origins = "*")  // Allow requests from any origin
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public CalculationResult calculate(@RequestBody CalculationRequest request) {
        return calculatorService.calculate(request);
    }
}