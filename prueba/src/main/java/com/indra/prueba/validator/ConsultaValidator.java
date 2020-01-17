package com.indra.prueba.validator;

import org.springframework.stereotype.Component;

@Component
public class ConsultaValidator {

    public boolean validateMinMax(Long min, Long max){
        return min < max;
    }
}
