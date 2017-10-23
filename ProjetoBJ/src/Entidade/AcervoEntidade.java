/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Enum.TipoAcervoEnum;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aluno
 */
@Entity
public class AcervoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private long numeroObras;
    private TipoAcervoEnum tipoAcervo;
    private Collection<ObraEntidade> obras;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroObras() {
        return numeroObras;
    }

    public void setNumeroObras(long numeroObras) {
        this.numeroObras = numeroObras;
    }

    public TipoAcervoEnum getTipoAcervo() {
        return tipoAcervo;
    }

    public void setTipoAcervo(TipoAcervoEnum tipoAcervo) {
        this.tipoAcervo = tipoAcervo;
    }

    public Collection<ObraEntidade> getObras() {
        return obras;
    }

    public void setObras(ObraEntidade obras) {
        this.obras.add(obras);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
