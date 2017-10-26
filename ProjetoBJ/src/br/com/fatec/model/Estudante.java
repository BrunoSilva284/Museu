/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

import javax.persistence.Entity;

/**
 *
 * @author bruno.a.da.silva
 */
@Entity
public class Estudante extends Visitante{
    
    private String documentoEscolar;

    public String getDocumentoEscolar() {
        return documentoEscolar;
    }

    public void setDocumentoEscolar(String documentoEscolar) {
        this.documentoEscolar = documentoEscolar;
    }
    
}
