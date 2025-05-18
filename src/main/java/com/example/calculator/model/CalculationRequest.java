package com.example.calculator.model;

import lombok.Data;

@Data
public class CalculationRequest {
    private double num1;
    private double num2;
    private String operation;
}