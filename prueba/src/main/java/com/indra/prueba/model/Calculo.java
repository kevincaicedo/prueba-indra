package com.indra.prueba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Calculo extends Audit {

    public Calculo(Long resultado, String usuario){
        this.resultado = resultado;
        this.usuario = usuario;
    }

    private Long id;
    private Long resultado;
    private String usuario;
}
