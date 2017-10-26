/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Estudante;
import br.com.fatec.model.Visita;
import br.com.fatec.model.Visitante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
/**
 *
 * @author aluno
 */
public class GerenciarVisita {
    
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
    
    public void iniciarVisita(String cpf) throws SQLException, ClassNotFoundException{
        Visita visita = new Visita();
        visita.setDataHoraEntrada(Calendar.getInstance());
        visita.setIdCartao(this.emitirCartao());
        visita.setVisitante(this.consultarVisitante(cpf));
        BancoConexao.salvar(visita);

    }
    
    public void encerrarVisita(String cpf) throws ClassNotFoundException, SQLException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao()
                .prepareStatement("SELECT max(codigo),max(idVisitante) FROM VISITA, VISITANTE"
                + " WHERE visitante_idVisitante = (SELECT max(idVisitante)"
                        + " FROM VISITANTE WHERE cpf ='" + cpf + "')");
        ResultSet rs = stm.executeQuery();

        Visitante visit = null;
        if (rs.next()) { //percorre todos os registros
            visit = BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
        } 
        Visita visita = BancoConexao.buscar(Visita.class, rs.getInt("max(codigo)"));
        visita.setDataHoraSaida(Calendar.getInstance());
        BancoConexao.atualizar(visita);
    }
    
    public Visitante consultarVisitante(String cpf) throws SQLException, ClassNotFoundException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(idVisitante) FROM VISITANTE"
                + " WHERE cpf ='" + cpf + "'");
        ResultSet rs = stm.executeQuery();

        Visitante visit = null;
        if (rs.next()) { //percorre todos os registros
            visit = BancoConexao.buscar(Visitante.class, rs.getInt("max(idVisitante)"));
        } 
        return visit;
    }
    
    
    private int emitirCartao() throws SQLException, ClassNotFoundException{
        BancoConexao.conectar();
        
        PreparedStatement stm = BancoConexao.getConexao()
                                .prepareStatement("SELECT max(idCartao) "
                                        + "FROM VISITA");
        ResultSet rs = stm.executeQuery();
        int idCartao = 1;
        if (rs.next()) { //percorre todos os registros
            idCartao = rs.getInt("max(idCartao)");
        }
        rs.close();
        BancoConexao.desconectar();
        return idCartao+1;
    }
}
