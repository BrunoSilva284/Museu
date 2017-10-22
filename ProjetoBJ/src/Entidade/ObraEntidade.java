/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Enum.TipoObraEnum;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class ObraEntidade {
    
    private long codigo;
    private String nome;
    private Date dataCriacao;
    private String autor;
    private String descricao;
    private TipoObraEnum classificacao;
    private String localProducao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoObraEnum getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(TipoObraEnum classificacao) {
        this.classificacao = classificacao;
    }

    public String getLocalProducao() {
        return localProducao;
    }

    public void setLocalProducao(String localProducao) {
        this.localProducao = localProducao;
    }
    
}
