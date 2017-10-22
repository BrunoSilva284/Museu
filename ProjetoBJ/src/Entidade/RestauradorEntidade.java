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
public class RestauradorEntidade {
    
    private String nomeRestaurador;
    private long numCracha;
    private Collection<RestauracaoEntidade> restauracoesEmAndamento;
    
    public Collection<RestauracaoEntidade> getRestauracoesEmAndamento() {
        return restauracoesEmAndamento;
    }

    public void setRestauracoesEmAndamento(RestauracaoEntidade restauracoesEmAndamento) {
        this.restauracoesEmAndamento.add(restauracoesEmAndamento);
    }
    
    public String getNomeRestaurador() {
        return nomeRestaurador;
    }

    public void setNomeRestaurador(String nomeRestaurador) {
        this.nomeRestaurador = nomeRestaurador;
    }

    public long getNumCracha() {
        return numCracha;
    }

    public void setNumCracha(long numCracha) {
        this.numCracha = numCracha;
    }
    
}
