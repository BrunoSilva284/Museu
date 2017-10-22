/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidade.VisitanteEntidade;
import Banco.BancoConexao;
/**
 *
 * @author aluno
 */
public class VisitaController {
    
    public void registrarVisitante(String nome, String email, String cpf, String tel)
    {
        
        VisitanteEntidade visitante = new VisitanteEntidade();
        visitante.setCpf(cpf);
        visitante.setEmail(email);
        visitante.setNome(nome);
        visitante.setTelefone(tel);
        
        String sql = "INSERT INTO VISITANTE (NOME,EMAIL,CPF,TEL)"
            + "VALUES ('" + nome + "','" + email + "','" + cpf + "','" + tel + "')";
        
        BancoConexao.save(sql);

    }
    
    public void consultarVisitante()
    {
        
    }
}
