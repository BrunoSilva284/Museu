/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Banco.BancoConexao;
import Enum.TipoObraEnum;
import java.sql.Date;

/**
 *
 * @author bruno
 */
public class TestaObra {
    
    public static void main(String[] args){
        ObraEntidade obra = new ObraEntidade();
        obra.setAutor("Bruno");
        obra.setClassificacao(TipoObraEnum.QUADRO);
        obra.setDataCriacao(Date.valueOf("2017-10-22"));
        obra.setDescricao("Um quadro sensacional");
        obra.setLocalProducao("Diadema");
        obra.setNome("Monazika");
        
        BancoConexao.salvar(obra);
    }
}
