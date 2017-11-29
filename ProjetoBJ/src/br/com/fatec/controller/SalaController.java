package br.com.fatec.controller;

import br.com.fatec.util.BancoConexao;
import br.com.fatec.model.Sala;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.a.da.silva
 */
public class SalaController {
         
    public Sala consultarSala(int numero) throws SQLException, ClassNotFoundException, NullPointerException {
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT * FROM SALA"
                + " WHERE numero=" + numero);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) { //percorre todos os registros            
            Sala sala = BancoConexao.buscar(Sala.class, rs.getInt("numero"));
            return sala;                        
        }
        rs.close();
        BancoConexao.desconectar();
        return null;
    }
    
    public List<Sala> listarSalas(String where) throws SQLException, ClassNotFoundException, NullPointerException {
        List<Sala> salas = new ArrayList<>();
        BancoConexao.conectar();
        PreparedStatement stm = BancoConexao.getConexao().prepareStatement("SELECT * FROM SALA "
                + where);
        ResultSet rs = stm.executeQuery();

        while(rs.next()) { //percorre todos os registros            
            Sala sala = BancoConexao.buscar(Sala.class, rs.getInt("numero"));
            salas.add(sala);                        
        }
        rs.close();
        BancoConexao.desconectar();
        return salas;
    }
    
    public void atualizarSala(Sala sala){
        BancoConexao.atualizar(sala);
    }
}
