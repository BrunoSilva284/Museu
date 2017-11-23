/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.model.Obra;
import br.com.fatec.model.StatusObraEnum;
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
        obra.setStatus(StatusObraEnum.NOVA);
        BancoConexao.salvar(obra);
    }
     
    public Obra consultarObra(String nome) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT max(codigo) FROM OBRA"
                + " WHERE nome like '" + nome + "%'");
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros            
            Obra obra = BancoConexao.buscar(Obra.class, rs.getInt("max(codigo)"));
            return obra;                        
        }
        rs.close();
        BancoConexao.desconectar();
        return null;
    }
    public void alterarObra(String busca, String nome, Calendar dataCriacao, String autor, 
            String descricao, TipoObraEnum tipoObra, String localProducao, String caminhoImagem) throws SQLException, ClassNotFoundException, NullPointerException {
        Obra obra = consultarObra(busca);
        obra.setNome(nome);
        obra.setAutor(autor);
        obra.setCaminhoImg(caminhoImagem);
        obra.setClassificacao(tipoObra);
        obra.setDataCriacao(dataCriacao);
        obra.setDescricao(descricao);
        obra.setLocalProducao(localProducao);
        obra.setNome(nome);
        
        BancoConexao.atualizar(obra);
    }
    
    public void excluirObra(String nome) throws SQLException, ClassNotFoundException, NullPointerException {
        Obra obra = this.consultarObra(nome);
        BancoConexao.remover(obra, obra.getCodigo());
    }
    
}
