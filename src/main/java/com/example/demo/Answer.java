package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Answer {
    private @Id @GeneratedValue Long id;
    private String reconocido;
    private String accion;
    private Date creado;

    Answer() {}

    public Answer(String recon, String accion){
        this.reconocido=recon;
        this.accion=accion;
        creado=new Date();
    }
}
