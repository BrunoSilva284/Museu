/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Exposicao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class ExposicaoController {
    
    public Exposicao consultarExposicao(String nome) throws SQLException, ClassNotFoundException, NullPointerException{
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(codigo) FROM EXPOSICAO"
                + " WHERE nome like '" + nome + "%'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros
            Exposicao exposicao = BancoConexao.buscar(Exposicao.class, rs.getInt("max(codigo)"));
            return exposicao;                        
        }
        BancoConexao.desconectar();
        return null;
    }
    
    public void registrarExposicao(Exposicao exposicao) throws SQLException, ClassNotFoundException, NullPointerException{
        BancoConexao.salvar(exposicao);
    }
}
