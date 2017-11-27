package br.com.fatec.controller;

import br.com.fatec.model.Exposicao;
import br.com.fatec.model.Obra;
import br.com.fatec.model.Sala;
import br.com.fatec.model.StatusObraEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
            exposicao.setObras(new HashSet<>(BancoConexao.buscarLista("select o from Obra o where exposicao_codigo ="+exposicao.getCodigo())));
            rs.close();
            return exposicao;                        
        }
        BancoConexao.desconectar();
        return null;
    }
    
    public void registrarExposicao(Exposicao exposicao) throws SQLException, ClassNotFoundException, NullPointerException{
        BancoConexao.salvar(exposicao);
        atualizarObras(consultarExposicao(exposicao.getNome()), "ADD");
        atualizarSala(exposicao, "RESERVADA");
    }
    
    public void atualizarExposicao(Exposicao exposicao, String busca) throws SQLException, ClassNotFoundException, NullPointerException{
        Exposicao expo = this.consultarExposicao(busca);
        atualizarSala(expo, "LIVRE");//atualiza a antiga         
        expo.setNome(exposicao.getNome());
        expo.setDataInicio(exposicao.getDataInicio());
        expo.setDataFim(exposicao.getDataFim());
        expo.setTipo(exposicao.getTipo());
        expo.setObras(exposicao.getObras());
        atualizarObras(expo, "ADD");
        expo.setSala(exposicao.getSala());
        BancoConexao.atualizar(expo);
        atualizarSala(expo, "RESERVADA");

    }
    
    public void excluirExposicao(String nome)throws SQLException, ClassNotFoundException, NullPointerException{        
        Exposicao exposicao = this.consultarExposicao(nome);
        atualizarObras(exposicao, "REMOVER");
        atualizarSala(exposicao, "LIVRE"); 
        BancoConexao.remover(exposicao, exposicao.getCodigo());
    }
    
    public void atualizarObras(Exposicao expo, String tipo) throws SQLException, ClassNotFoundException, NullPointerException{
        AcervoController acervo = new AcervoController();
        Set<Obra> obras = expo.getObras();
        Iterator<Obra> it = obras.iterator();
        while(it.hasNext()){
            Obra obr = acervo.consultarObra(it.next().getNome());
            if(tipo.equals("REMOVER")){
                obr.setExposicao(null);
                obr.setStatus(StatusObraEnum.GUARDADA);
            }else{
                obr.setExposicao(expo);
                obr.setStatus(StatusObraEnum.EXIBICAO);
            }
            acervo.atualizarObra(obr);            
        }
    }
    
    public void atualizarSala (Exposicao expo, String tipo) throws SQLException, ClassNotFoundException, NullPointerException{
        SalaController salGer = new SalaController();
        Sala sala = expo.getSala();        
        sala.setStatus(tipo);  
        salGer.atualizarSala(sala);   
    }
}
