package com.indra.prueba.controller;

import com.indra.prueba.common.MessageResponse;
import com.indra.prueba.common.ParamSearch;
import com.indra.prueba.model.Calculo;
import com.indra.prueba.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CalculoController {

    private final CalculoService calculoService;

    @Autowired
    public CalculoController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

    @PostMapping(value = "/calculo", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<MessageResponse> saveCalculo(@Valid @RequestBody Calculo calculo) throws Exception {
        return ResponseEntity.ok(calculoService.saveCalculo(calculo));
    }

    @PostMapping(value = "/calculo/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Calculo>> searchCalculo(@Valid @RequestBody ParamSearch paramSearch) throws Exception {
        return ResponseEntity.ok(calculoService.getCalculosByRange(paramSearch));
    }

}
