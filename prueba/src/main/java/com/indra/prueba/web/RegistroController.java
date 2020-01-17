package com.indra.prueba.web;

import com.indra.prueba.model.Calculo;
import com.indra.prueba.model.MessageResponse;
import com.indra.prueba.service.CalculoService;
import com.indra.prueba.validator.RegistroValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@RequestScope
public class RegistroController {

    private CalculoForm calculoForm;
    private CalculoService calculoService;
    private RegistroValidator registroValidator;
    private MessageResponse messageResponse = new MessageResponse();

    @Autowired
    public RegistroController(CalculoForm calculoForm, CalculoService calculoService, RegistroValidator registroValidator){
        this.calculoForm = calculoForm;
        this.calculoService = calculoService;
        this.registroValidator = registroValidator;
    }

    public void saveCalculo(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!registroValidator.rangeLimit(calculoForm.getLimite())) {
            context.addMessage(null, new FacesMessage("Limite no valido"));
            return;
        }

        final Calculo calculo = new Calculo(
            calculoService.sumParLimit(calculoForm.getLimite()),
            calculoForm.getUsuario().trim()
        );

        try {
          messageResponse = calculoService.saveCalculo(calculo);

            if(messageResponse.getState() == 401)
                context.addMessage(null, new FacesMessage("Usuario no valido"));
            else {
              context.addMessage(null, new FacesMessage("Resultado: "+calculo.getResultado()));
              calculoForm.setLimite(null);
              calculoForm.setUsuario("");
            }
        } catch (Exception e){
            context.addMessage(null, new FacesMessage("Ocurrio un error"));
        }
    }

}
