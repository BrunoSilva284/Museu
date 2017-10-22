/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Enum.TipoAcervoEnum;
import java.util.Collection;

/**
 *
 * @author aluno
 */
public class AcervoEntidade {
    
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
}
