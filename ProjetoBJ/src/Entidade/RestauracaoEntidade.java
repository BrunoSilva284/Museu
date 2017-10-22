/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Enum.StatusRestEnum;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class RestauracaoEntidade {
    
    private long idRestauracao;
    private String detalhesRestauracao;
    private Date dataInicioRestauracao;
    private Date dataFimRestauracao;
    private StatusRestEnum statusRestauracao;
    private double valorRestauracao;
    private RestauradorEntidade restaurador;
    private ObraEntidade obra;
    
    public RestauradorEntidade getRestaurador() {
        return restaurador;
    }

    public void setRestaurador(RestauradorEntidade restaurador) {
        this.restaurador = restaurador;
    }
    
    public long getIdRestauracao() {
        return idRestauracao;
    }

    public void setIdRestauracao(long idRestauracao) {
        this.idRestauracao = idRestauracao;
    }

    public String getDetalhesRestauracao() {
        return detalhesRestauracao;
    }

    public void setDetalhesRestauracao(String detalhesRestauracao) {
        this.detalhesRestauracao = detalhesRestauracao;
    }

    public Date getDataInicioRestauracao() {
        return dataInicioRestauracao;
    }

    public void setDataInicioRestauracao(Date dataInicioRestauracao) {
        this.dataInicioRestauracao = dataInicioRestauracao;
    }

    public Date getDataFimRestauracao() {
        return dataFimRestauracao;
    }

    public void setDataFimRestauracao(Date dataFimRestauracao) {
        this.dataFimRestauracao = dataFimRestauracao;
    }

    public StatusRestEnum getStatusRestauracao() {
        return statusRestauracao;
    }

    public void setStatusRestauracao(StatusRestEnum statusRestauracao) {
        this.statusRestauracao = statusRestauracao;
    }

    public double getValorRestauracao() {
        return valorRestauracao;
    }

    public void setValorRestauracao(double valorRestauracao) {
        this.valorRestauracao = valorRestauracao;
    }

    public ObraEntidade getObra() {
        return obra;
    }

    public void setObra(ObraEntidade obra) {
        this.obra = obra;
    }
    
}
