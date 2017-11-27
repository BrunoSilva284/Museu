package br.com.fatec.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bruno.a.da.silva
 */
@Entity
public class Restauracao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;    
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;   
    @Temporal(TemporalType.DATE)
    private Calendar dataFim;
    private double valor;
    @Enumerated(EnumType.STRING)
    private StatusRestauracao status;
    @OneToOne
    private Restaurador restaurador;
    @OneToOne
    private Obra obra;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusRestauracao getStatus() {
        return status;
    }

    public void setStatus(StatusRestauracao status) {
        this.status = status;
    }

    public Restaurador getRestaurador() {
        return restaurador;
    }

    public void setRestaurador(Restaurador restaurador) {
        this.restaurador = restaurador;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
    

}
