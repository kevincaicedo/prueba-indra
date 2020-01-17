package com.indra.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class Audit implements Serializable {

    private static final long serialVersionUID = 5656664454L;

    private Date createdAt;
    private Date updatedAt;

}