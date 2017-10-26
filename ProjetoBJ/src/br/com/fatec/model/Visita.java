package br.com.fatec.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aluno
 */
@Entity
public class Visita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraEntrada;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraSaida;
    
    private long idCartao;
    private double valorEntrada = 25;
    private static int numMaxVisitantes = 200;
    
    @ManyToOne
    private Visitante visitante;
    
    
    public Visitante getVisitante() {
        return visitante;
    }
    
    public void setVisitante(Visitante visitante){
        this.visitante = visitante;
    }
    
    public static void setNumMaxVisitantes(int numMax) {
       numMaxVisitantes = numMax;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public static int getNumMaxVisitantes() {
       return numMaxVisitantes;
    }
    
    public Calendar getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Calendar dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Calendar getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Calendar dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(long idCartao) {
        this.idCartao = idCartao;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double novoValor) {
        this.valorEntrada = novoValor;
    }
    
    
}
