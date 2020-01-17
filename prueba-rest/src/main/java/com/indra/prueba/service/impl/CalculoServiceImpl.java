package com.indra.prueba.service.impl;

import com.indra.prueba.common.MessageResponse;
import com.indra.prueba.common.ParamSearch;
import com.indra.prueba.exception.NotFoundException;
import com.indra.prueba.model.Calculo;
import com.indra.prueba.repository.CalculoRepository;
import com.indra.prueba.service.CalculoService;
import com.indra.prueba.util.FakeUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoServiceImpl implements CalculoService {

    private final CalculoRepository calculoRepository;

    public CalculoServiceImpl(CalculoRepository calculoRepository) {
        this.calculoRepository = calculoRepository;
    }

    @Override
    public MessageResponse saveCalculo(Calculo calculo) throws Exception {
        if(!FakeUsers.exist(calculo.getUsuario()))
            return new MessageResponse("Usuario no valido", 401);

        calculoRepository.save(calculo);
        return new MessageResponse("Calculo Registrado", 200);
    }

    @Override
    public List<Calculo> getCalculosByRange(ParamSearch paramSearch) throws Exception {

        if(paramSearch.getName() == null || paramSearch.getName().isEmpty())
            return calculoRepository.findCalculosByResultadoBetween(
                    paramSearch.getMin(), paramSearch.getMax());

        return calculoRepository.findCalculosByResultadoBetweenAndUsuario(
                paramSearch.getMin(), paramSearch.getMax(), paramSearch.getName());
    }
}
