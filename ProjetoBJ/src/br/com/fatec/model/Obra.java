/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aluno
 */
@Entity
public class Obra {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Calendar dataCriacao;
    private String autor;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoObraEnum classificacao;
    private String localProducao;
    private String caminhoImg;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
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

    public String getCaminhoImg() {
        return caminhoImg;
    }

    public void setCaminhoImg(String caminhoImg) {
        this.caminhoImg = caminhoImg;
    }
    
}
