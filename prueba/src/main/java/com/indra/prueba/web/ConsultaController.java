package com.indra.prueba.web;

import com.indra.prueba.model.Calculo;
import com.indra.prueba.model.ParamSearch;
import com.indra.prueba.service.CalculoService;
import com.indra.prueba.validator.ConsultaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
public class ConsultaController {

    private CalculoService calculoService;
    private ConsultaForm consultaForm;
    private ConsultaValidator consultaValidator;
    List<Calculo> calculoList = new ArrayList();

    @Autowired
    public  ConsultaController(CalculoService calculoService, ConsultaForm consultaForm, ConsultaValidator consultaValidator){
        this.calculoService = calculoService;
        this.consultaForm = consultaForm;
        this.consultaValidator = consultaValidator;
    }

    public List<Calculo> getListCalculos(){
        return calculoList;
    }

    public void consultar(){
        FacesContext context = FacesContext.getCurrentInstance();

        Long minValue = consultaForm.getMin();
        Long maxValue = consultaForm.getMax();

        if(minValue == null)
            minValue = 0L;

        if(maxValue == null)
            maxValue = Long.MAX_VALUE;

        if(!consultaValidator.validateMinMax(minValue, maxValue)){
            context.addMessage(null, new FacesMessage("Resultado minimo invalido"));
            return;
        }

        final ParamSearch paramSearch = new ParamSearch(
                consultaForm.getName(),
                minValue, maxValue
        );

        try {
            calculoList = (List<Calculo>) calculoService.listCalculoByRange(paramSearch);
        } catch (Exception e){
            context.addMessage(null, new FacesMessage("Ocurrio un error"));
        }
    }

}
