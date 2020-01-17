package com.indra.prueba.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class CalculoForm implements Serializable {
    private Long id;
    private Long limite;
    private String usuario;
}
