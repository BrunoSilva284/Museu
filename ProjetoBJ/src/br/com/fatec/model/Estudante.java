package br.com.fatec.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author bruno.a.da.silva
 */
@Entity
public class Estudante extends Visitante implements Serializable{
    
    private String documentoEscolar;

    public String getDocumentoEscolar() {
        return documentoEscolar;
    }

    public void setDocumentoEscolar(String documentoEscolar) {
        this.documentoEscolar = documentoEscolar;
    }    
}
