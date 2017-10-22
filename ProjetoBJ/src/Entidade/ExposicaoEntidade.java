/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.util.Collection;

/**
 *
 * @author aluno
 */
public class ExposicaoEntidade {
    
    private long codExposicao;
    private String nomeExposicao;
    private int qtdObras;
    private String descExposicao;
    private Collection<ObraEntidade> obras;
    private SalaEntidade sala;

    public long getCodExposicao() {
        return codExposicao;
    }

    public void setCodExposicao(long codExposicao) {
        this.codExposicao = codExposicao;
    }

    public String getNomeExposicao() {
        return nomeExposicao;
    }

    public void setNomeExposicao(String nomeExposicao) {
        this.nomeExposicao = nomeExposicao;
    }

    public int getQtdObras() {
        return qtdObras;
    }

    public void setQtdObras(int qtdObras) {
        this.qtdObras = qtdObras;
    }

    public String getDescExposicao() {
        return descExposicao;
    }

    public void setDescExposicao(String descExposicao) {
        this.descExposicao = descExposicao;
    }

    public Collection<ObraEntidade> getObras() {
        return obras;
    }

    public void setObras(ObraEntidade obra) {
        this.obras.add(obra);
    }

    public SalaEntidade getSala() {
        return sala;
    }

    public void setSala(SalaEntidade sala) {
        this.sala = sala;
    }
    
}
