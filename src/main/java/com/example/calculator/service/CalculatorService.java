package com.example.calculator.service;

import com.example.calculator.exception.InvalidOperationException;
import com.example.calculator.model.CalculationRequest;
import com.example.calculator.model.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResult calculate(CalculationRequest request) {
        double result;
        String message;

        switch (request.getOperation().toLowerCase()) {
            case "add":
                result = request.getNum1() + request.getNum2();
                message = "Addition performed";
                break;
            case "subtract":
                result = request.getNum1() - request.getNum2();
                message = "Subtraction performed";
                break;
            case "multiply":
                result = request.getNum1() * request.getNum2();
                message = "Multiplication performed";
                break;
            case "divide":
                if (request.getNum2() == 0) {
                    throw new InvalidOperationException("Cannot divide by zero");
                }
                result = request.getNum1() / request.getNum2();
                message = "Division performed";
                break;
            case "power":
                result = Math.pow(request.getNum1(), request.getNum2());
                message = "Power operation performed";
                break;
            case "sqrt":
                if (request.getNum1() < 0) {
                    throw new InvalidOperationException("Cannot calculate square root of negative number");
                }
                result = Math.sqrt(request.getNum1());
                message = "Square root performed";
                break;
            default:
                throw new InvalidOperationException("Invalid operation: " + request.getOperation());
        }

        return new CalculationResult(result, request.getOperation(), message);
    }
}