package com.indra.prueba.service;

import com.indra.prueba.common.MessageResponse;
import com.indra.prueba.common.ParamSearch;
import com.indra.prueba.model.Calculo;

import java.util.List;

public interface CalculoService {
    MessageResponse saveCalculo(Calculo calculo) throws Exception;
    List<Calculo> getCalculosByRange(ParamSearch paramSearch) throws Exception;
}
