package com.indra.prueba.service;

import com.indra.prueba.model.Calculo;
import com.indra.prueba.model.MessageResponse;
import com.indra.prueba.model.ParamSearch;
import com.indra.prueba.rest.CalculoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoService {

    private CalculoApi calculoApi;

    @Autowired
    public CalculoService(CalculoApi calculoApi){
        this.calculoApi = calculoApi;
    }

    public MessageResponse saveCalculo(Calculo calculo){
        return calculoApi.saveCalculo(calculo);
    }

    public List listCalculoByRange(ParamSearch paramSearch){
        return calculoApi.getCalculosByRange(paramSearch);
    }

    public Long sumParLimit(Long limit){
        long suma = 0;
        for(int i = 2; i <= limit; i++){
            if(i % 2 == 0)
                suma += i;
        }
        return suma;
    }

}
