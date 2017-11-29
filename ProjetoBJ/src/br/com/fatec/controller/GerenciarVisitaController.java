package br.com.fatec.controller;

import br.com.fatec.util.BancoConexao;
import br.com.fatec.model.Estudante;
import br.com.fatec.model.Visita;
import br.com.fatec.model.Visitante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author aluno
 */
public class GerenciarVisitaController {
    
    public void registrarVisitante(String nome,String email, String cpf, 
            String tel, boolean estudante, String docE) {
        if(estudante){
            Estudante visit = new Estudante();
            visit.setNome(nome);
            visit.setEmail(email);
            visit.setCpf(cpf);
            visit.setTelefone(tel);
            visit.setDocumentoEscolar(docE);
            BancoConexao.salvar(visit);            
        }
        else{
            Visitante visit = new Visitante();
            visit.setNome(nome);
            visit.setEmail(email);
            visit.setCpf(cpf);
            visit.setTelefone(tel);
            BancoConexao.salvar(visit);
        }
    }
    
    public List<String> retornarVisitante(String cpf) throws SQLException, ClassNotFoundException, NullPointerException{
        List<String> retorno = new ArrayList();
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(idVisitante),DTYPE FROM VISITANTE"
                + " WHERE cpf ='" + cpf + "'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros
            if(rs.getString("DTYPE").equalsIgnoreCase("ESTUDANTE")){
                Estudante visitante = (Estudante)consultarVisitante(cpf);
                retorno.add(visitante.getCpf());
                retorno.add(visitante.getEmail());
                retorno.add(visitante.getNome());
                retorno.add(visitante.getTelefone());
                retorno.add(visitante.getDocumentoEscolar());
            }
            else{
                Visitante visitante = (Visitante)consultarVisitante(cpf);
                retorno.add(visitante.getCpf());
                retorno.add(visitante.getEmail());
                retorno.add(visitante.getNome());
                retorno.add(visitante.getTelefone());
            }
        }       
        rs.close();
        BancoConexao.desconectar();
        return retorno;
    }
    
    public void iniciarVisita(String cpf) throws SQLException, ClassNotFoundException, NullPointerException{
        Visita visita = new Visita();
        visita.setDataHoraEntrada(Calendar.getInstance());
        visita.setIdCartao(this.emitirCartao());
        visita.setVisitante(this.consultarVisitante(cpf));
        visita.setValorEntrada(valorEntrada(cpf));
        BancoConexao.salvar(visita);
    }
    
    public double valorEntrada(String cpf) throws ClassNotFoundException, SQLException, NullPointerException{
        BancoConexao.conectar();
        Visita vis = new Visita();                
        double retorno = vis.getValorEntrada();
        PreparedStatement stm = BancoConexao.getConexao()
                .prepareStatement("SELECT DTYPE FROM VISITANTE"
                + " WHERE cpf = '" + cpf + "'");
        ResultSet rs = stm.executeQuery();
        if (rs.next()) { //percorre todos os registros
            String tipo = rs.getString("DTYPE");
            if(tipo.equalsIgnoreCase("Estudante")){
                retorno = retorno/2;
            }
        }
        rs.close();
        BancoConexao.desconectar();
        return retorno;
    }
    
    public void encerrarVisita(String cpf) throws ClassNotFoundException, SQLException, NullPointerException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao()
                .prepareStatement("SELECT max(codigo),max(idVisitante) FROM VISITA, VISITANTE"
                + " WHERE visitante_idVisitante = (SELECT max(idVisitante)"
                        + " FROM VISITANTE WHERE cpf ='" + cpf + "')");
        ResultSet rs = stm.executeQuery();        
        Visitante visit = null;
        if (rs.next()) { //percorre todos os registros
            visit = BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
            Visita visita = BancoConexao.buscar(Visita.class, rs.getInt("max(codigo)"));
            visita.setDataHoraSaida(Calendar.getInstance());
            BancoConexao.atualizar(visita);
        }
        else{
            rs.close();
            return;
        }
        rs.close();
        BancoConexao.desconectar();
    }
    
    public void atualizarVisitante(String nome,String email, String cpf, 
            String tel, boolean estudante, String docE) throws SQLException, ClassNotFoundException, NullPointerException{
        if(estudante){
            Estudante visit = (Estudante) consultarVisitante(cpf);
            visit.setNome(nome);
            visit.setEmail(email);
            visit.setTelefone(tel);
            visit.setDocumentoEscolar(docE);
            BancoConexao.atualizar(visit);            
        }
        else{
            Visitante visit = consultarVisitante(cpf);
            visit.setNome(nome);
            visit.setEmail(email);
            visit.setTelefone(tel);
            BancoConexao.atualizar(visit);
        }
    }
    
    
    public Visitante consultarVisitante(String cpf) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(idVisitante),DTYPE FROM VISITANTE"
                + " WHERE cpf ='" + cpf + "'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros
            if(rs.getString("DTYPE").equals("ESTUDANTE")){
                Estudante visit = null;
                visit = (Estudante) BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
                rs.close();
                return visit;
            }else{
                Visitante visit = null;
                visit = BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
                rs.close();
                return visit;
            }            
        }
        rs.close();
        BancoConexao.desconectar();
        return null;
    }
    
    public void excluirVisitante(Visitante visit) throws ClassNotFoundException, SQLException, NullPointerException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(idVisitante) FROM VISITANTE"
                + " WHERE cpf ='" + visit.getCpf() + "'");
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            Visitante v = BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
            BancoConexao.remover(v,v.getIdVisitante());
        }
        rs.close();
        BancoConexao.desconectar();
    }
    
    private int emitirCartao() throws SQLException, ClassNotFoundException{
        BancoConexao.conectar();
        
        PreparedStatement stm = BancoConexao.getConexao()
                          .prepareStatement("SELECT max(idCartao) FROM VISITA");
        ResultSet rs = stm.executeQuery();
        int idCartao = 1;
        if (rs.next()) { //percorre todos os registros
            idCartao = rs.getInt("max(idCartao)");
        }
        rs.close();
        BancoConexao.desconectar();
        return idCartao+1;
    }
    
    public boolean iniciouVisita(String cpf) throws ClassNotFoundException, SQLException, NullPointerException{
        boolean retorno = false;
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao()
                .prepareStatement("select codigo,dataHoraEntrada, dataHoraSaida from visita "
                        + "where visitante_idVisitante = "
                        + "(select max(idVisitante) from visitante "
                        + "where cpf = '" + cpf + "') order by codigo desc");
        ResultSet rs = stm.executeQuery();                
        if (rs.next()) { 
            if(rs.getString("dataHoraSaida")==null){
                retorno = true;
            }
        }
        else{
            retorno = false;
        }
        rs.close();
        BancoConexao.desconectar();
        return retorno;
    }
}
