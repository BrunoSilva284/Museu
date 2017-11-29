package br.com.fatec.controller;

import br.com.fatec.enums.StatusObraEnum;
import br.com.fatec.enums.StatusRestauracao;
import br.com.fatec.model.Obra;
import br.com.fatec.model.Restauracao;
import br.com.fatec.model.Restaurador;
import br.com.fatec.util.BancoConexao;
import br.com.fatec.view.GerenciarRestauracao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class RestauracaoController {
     
    private final AcervoController acervo = new AcervoController();
    
    public void registrarRestauracao(String restaurador, Obra obra, String valor, String dataInicio,
            String dataFim){
        try {
            Restauracao restauracao = new Restauracao();
            restauracao.setRestaurador(consultarRestaurador(restaurador));
            obra.setStatus(StatusObraEnum.RESTAURANDO);
            acervo.atualizarObra(obra);
            restauracao.setObra(obra);
            restauracao.setStatus(StatusRestauracao.NOVA);
            restauracao.setValor(Double.parseDouble(valor));
            Calendar dataCal = Calendar.getInstance();
            Date data = Date.valueOf(dataInicio);
            dataCal.setTime(data);
            restauracao.setDataInicio(dataCal);
            data = Date.valueOf(dataFim);
            dataCal.setTime(data);
            restauracao.setDataFim(dataCal);
            BancoConexao.salvar(restauracao);
            atualizarRestaurador(restauracao.getRestaurador(), restauracao);
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            Logger.getLogger(GerenciarRestauracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void alterarRestauracao(String restaurador, Obra obra, String valor, String dataInicio,
            String dataFim, StatusRestauracao status){
        try {
            Restauracao restauracao = consultarRestauracao(obra.getNome());
            //atualizar o antigo
            atualizarRestaurador(restauracao.getRestaurador(), null);
            restauracao.setRestaurador(consultarRestaurador(restaurador));
            restauracao.setStatus(status);
            restauracao.setValor(Double.parseDouble(valor));
            Calendar dataCal = Calendar.getInstance();
            Date data = Date.valueOf(dataInicio);
            dataCal.setTime(data);
            restauracao.setDataInicio(dataCal);
            data = Date.valueOf(dataFim);
            dataCal.setTime(data);
            restauracao.setDataFim(dataCal);
            BancoConexao.atualizar(restauracao);
            
            if(status == StatusRestauracao.FINALIZADA){
                obra.setStatus(StatusObraEnum.GUARDADA);
                acervo.atualizarObra(obra);
                atualizarRestaurador(restauracao.getRestaurador(), null);
            }
            else{
                atualizarRestaurador(restauracao.getRestaurador(), restauracao);
            }
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            Logger.getLogger(GerenciarRestauracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirRestauracao(String obra) throws SQLException, ClassNotFoundException, NullPointerException {
        Restauracao restauracao = consultarRestauracao(obra);
        atualizarRestaurador(restauracao.getRestaurador(), null);
        Obra obr = restauracao.getObra();
        obr.setStatus(StatusObraEnum.GUARDADA);
        acervo.atualizarObra(obr);
        BancoConexao.remover(restauracao, restauracao.getCodigo());
    }
    
    private void atualizarRestaurador(Restaurador restaurador, Restauracao restauracao) throws SQLException, ClassNotFoundException, NullPointerException{
        Restaurador rest = consultarRestaurador(restaurador.getNome());
        rest.setRestauracao(restauracao);
        BancoConexao.atualizar(rest);
    }
    
    public Restaurador consultarRestaurador(String nome) throws SQLException, ClassNotFoundException, NullPointerException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT cracha FROM RESTAURADOR"
                + " WHERE NOME = '" + nome + "'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros            
            Restaurador restaurador = BancoConexao.buscar(Restaurador.class, rs.getInt("cracha"));
            rs.close();
            return restaurador;                        
        }
        rs.close();
        BancoConexao.desconectar();
        return null;
    }
    
    public Restauracao consultarRestauracao(String nome) throws SQLException, ClassNotFoundException, NullPointerException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(codigo) FROM RESTAURACAO"
                + " WHERE obra_codigo = (SELECT codigo from OBRA where nome like '" + nome + "%')");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros            
            Restauracao restauracao = BancoConexao.buscar(Restauracao.class, rs.getInt("max(codigo)"));
            rs.close();
            return restauracao;                        
        }
        rs.close();
        BancoConexao.desconectar();
        return null;
    }
    public List<Restaurador> listarRestaurador(String where) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT * FROM RESTAURADOR"
                + " "+where);
        ResultSet rs = stm.executeQuery();
        List<Restaurador> restauradores = new ArrayList<>();
        while (rs.next()) { //percorre todos os registros            
            Restaurador restaurador = BancoConexao.buscar(Restaurador.class, rs.getInt("cracha"));
            restauradores.add(restaurador);
        }
        rs.close();
        BancoConexao.desconectar();
        return restauradores;
    }
    public List<Restauracao> listarRestauracao(String where) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT * FROM RESTAURACAO"
                + " "+where);
        ResultSet rs = stm.executeQuery();
        List<Restauracao> restauracoes = new ArrayList<>();
        while (rs.next()) { //percorre todos os registros            
            Restauracao restauracao = BancoConexao.buscar(Restauracao.class, rs.getInt("codigo"));
            restauracoes.add(restauracao);
        }
        rs.close();
        BancoConexao.desconectar();
        return restauracoes;
    } 
}
