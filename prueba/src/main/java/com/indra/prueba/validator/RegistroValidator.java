package com.indra.prueba.validator;

import org.springframework.stereotype.Component;

@Component
public class RegistroValidator {

    public boolean rangeLimit(Long limit){
        return limit >= 50 && limit <= 500;
    }

}
