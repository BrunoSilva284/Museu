/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Obra;
import br.com.fatec.model.TipoObraEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author aluno
 */
public class AcervoController {
    
     public void registrarObra(String nome, Calendar dataCriacao, String autor, 
            String descricao, TipoObraEnum TipoObra, String localProducao, String caminhoImagem) {
        Obra obra = new Obra();
        obra.setAutor(autor);
        obra.setCaminhoImg(caminhoImagem);
        obra.setClassificacao(TipoObra);
        obra.setDataCriacao(dataCriacao);
        obra.setDescricao(descricao);
        obra.setLocalProducao(localProducao);
        obra.setNome(nome);
        
        BancoConexao.salvar(obra);
    }
     
    public Obra consultarObra(String nome) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(codigo) FROM OBRA"
                + " WHERE nome ='" + nome + "'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros
            Obra obra = null;
            obra = BancoConexao.buscar(Obra.class, rs.getInt("max(codigo)"));
            return obra;
                        
        }
        BancoConexao.desconectar();
        return null;
    }
    public void alterarObra(String nome, Calendar dataCriacao, String autor, 
            String descricao, TipoObraEnum TipoObra, String localProducao, String caminhoImagem) throws SQLException, ClassNotFoundException, NullPointerException {
        Obra obra = consultarObra(nome);
        obra.setAutor(autor);
        obra.setCaminhoImg(caminhoImagem);
        obra.setClassificacao(TipoObra);
        obra.setDataCriacao(dataCriacao);
        obra.setDescricao(descricao);
        obra.setLocalProducao(localProducao);
        obra.setNome(nome);
        
        BancoConexao.atualizar(obra);
    }
    
    public void excluirObra(Obra obra) throws SQLException, ClassNotFoundException, NullPointerException {
 
    BancoConexao.conectar();
    PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(codigo) FROM OBRA"
        + " WHERE nome ='" + obra.getNome() + "'");
    ResultSet rs = stm.executeQuery();
    if(rs.next()){
        Obra o = BancoConexao.buscar(Obra.class, rs.getInt("max(codigo)"));
        BancoConexao.remover(o);
    }        
    BancoConexao.desconectar();
    }
}
