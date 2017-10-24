package Entidade;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author aluno
 */
@Entity
public class VisitaEntidade {
    
    @Id
    private int codigo;
    private Date dataHoraEntrada;
    private Date dataHoraSaida;
    private long idCartao;
    private double valorEntrada = 25;
    private VisitanteEntidade visitante;
    
    public VisitanteEntidade getVisitante() {
        return visitante;
    }
    
    public void setVisitante(VisitanteEntidade visitante){
        this.visitante = visitante;
    }
    
    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
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
