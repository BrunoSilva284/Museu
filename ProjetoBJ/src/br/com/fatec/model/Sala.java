package br.com.fatec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author bruno.a.da.silva
 */

@Entity
public class Sala {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    
    private int qtdVisitantes;
    
    private String status;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdVisitantes() {
        return qtdVisitantes;
    }

    public void setQtdVisitantes(int qtdVisitantes) {
        this.qtdVisitantes = qtdVisitantes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
