package com.indra.prueba.rest;

import com.indra.prueba.model.Calculo;
import com.indra.prueba.model.MessageResponse;
import com.indra.prueba.model.ParamSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CalculoApi {

    private final RestTemplate restTemplate;

    private final String basePath = "http://localhost:8080/api/";

    @Autowired
    public CalculoApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MessageResponse saveCalculo(Calculo calculo){
        return restTemplate.postForObject(basePath+"calculo", calculo, MessageResponse.class);
    }

    public List getCalculosByRange(ParamSearch paramSearch){
        return restTemplate.postForObject(basePath+"calculo/search", paramSearch, List.class);
    }
}
