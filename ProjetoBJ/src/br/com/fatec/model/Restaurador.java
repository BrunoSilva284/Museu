package br.com.fatec.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author bruno.a.da.silva
 */
@Entity
public class Restaurador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cracha;
    private String nome;
    @OneToOne
    private Restauracao restauracao;

    public int getCracha() {
        return cracha;
    }

    public void setCracha(int cracha) {
        this.cracha = cracha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Restauracao getRestauracao() {
        return restauracao;
    }

    public void setRestauracao(Restauracao restauracao) {
        this.restauracao = restauracao;
    }    
}
