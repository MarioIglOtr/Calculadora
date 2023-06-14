package com.sanitas.model.service.Impl;


import com.sanitas.model.exception.OperatorException;
import com.sanitas.model.service.CalculatorService;
import com.sanitas.model.strategy.Operation;
import com.sanitas.model.strategy.impl.SumaImpl;
import io.micrometer.common.util.StringUtils;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {



    @Override
    public Double calculate(@NonNull final Double num1, @NonNull final Double num2, @NonNull String operator) {
        operator = operator.replaceAll("\\s+", "");

        if (StringUtils.isBlank(operator) || !esOperadorValido(operator)) {
            throw new OperatorException("Operador inválido: " + operator);
        }
        final String operation = transformarOperacion(num1, num2, operator);

        return operSum(operation);
    }

    private String transformarOperacion(final Double num1, Double num2, String operator) {
        boolean cambiarOperador = false;
        if (num2 < 0.0) {
            cambiarOperador = true;
            num2 = Math.abs(num2);
        }

        if (cambiarOperador) {
            if (operator.equals("+")) {
                operator = "-";
            } else {
                operator = "+";
            }
        }

        return num1 + operator + num2;
    }





    //-----------------
    private double operRest(String operation) {

        if (operation.charAt(0) == '-') {
            operation = "0" + operation;
        }
        List<String> restas = new ArrayList<>();
        Collections.addAll(restas, operation.split("-"));

        double res = Double.parseDouble(restas.get(0));
        if (restas.size() == 1) {
            return Double.parseDouble(restas.get(0));
        }
        for (int i = 1; i < restas.size(); i++) {
            res -= Double.parseDouble(restas.get(i));
        }

        return res;
    }

    private double operSum(String operation) {

        List<String> sumas = new ArrayList<>();

        Collections.addAll(sumas, operation.split("\\+"));
        double result = 0;
        for (String op : sumas) {
            result += operRest(op);

        }

        return result;
    }

    private boolean esOperadorValido(final String operator) {
        return operator.equals("+") || operator.equals("-");
    }



}
