/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class EventoEntidade {
    
    private CuradorEntidade curador;
    private SalaEntidade sala;
    private long codigoEvento;
    private String nomeEvento;
    private int qtdVisitantes;
    private Date inicio;
    private Date encerramento;
    private String descricaoEvento;
    private String textoConvites;
    private Collection<VisitanteEntidade> visitantes;
    
    public Collection<VisitanteEntidade> getVisitantes() {
        return visitantes;
    }
    
    public void setVisitantes(VisitanteEntidade visitante){
        visitantes.add(visitante);
    }
    
    public CuradorEntidade getCurador() {
        return curador;
    }

    public void setCurador(CuradorEntidade curador) {
        this.curador = curador;
    }

    public SalaEntidade getSala() {
        return sala;
    }

    public void setSala(SalaEntidade sala) {
        this.sala = sala;
    }

    public long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getQtdVisitantes() {
        return qtdVisitantes;
    }

    public void setQtdVisitantes(int qtdVisitantes) {
        this.qtdVisitantes = qtdVisitantes;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(Date encerramento) {
        this.encerramento = encerramento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getTextoConvites() {
        return textoConvites;
    }

    public void setTextoConvites(String textoConvites) {
        this.textoConvites = textoConvites;
    }
    
}
