package br.com.fatec.model;

import br.com.fatec.controller.GerenciarVisitaController;
import java.sql.SQLException;
/**
 *
 * @author bruno
 */
public class TestaObra {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
//
//        Visitante eu = new Visitante();
//        eu.setCpf("999.888.777-66");
//        eu.setEmail("novoEu@gmail.com");
//        eu.setNome("Meu outro nome");
//        eu.setTelefone("4002-8922");
//
//        Visita visita = new Visita();
//        visita.setDataHoraEntrada(Calendar.getInstance());
//        visita.setIdCartao(1);
//        visita.setVisitante(eu);
//        
//        BancoConexao.salvar(eu);
//        BancoConexao.salvar(visita);

//        Visitante eu = BancoConexao.buscar(Visitante.class , 5);
//        if(eu != null){
//            System.out.println(eu.getCpf() + " " + eu.getEmail());
//        }else{
//            System.out.println("Objeto vazio");
//        }
//        
//        Visita visita = BancoConexao.buscar(Visita.class, eu.getIdVisitante());
//        
//        visita.setDataHoraSaida(Calendar.getInstance());
//        
//        BancoConexao.salvar(visita);
          String cpf = "123.456.789-09";
          GerenciarVisitaController ger = new GerenciarVisitaController();
//          
//          ger.registrarVisitante("BRUNO", "email",
//                  cpf, "4002-8922", true, "docE");
//          
//          ger.iniciarVisita(cpf);
//          
//          Visitante visit = ger.consultarVisitante(cpf);
//          System.out.println(visit.getNome() + " " + visit.getEmail());
            ger.atualizarVisitante("JOSE DA SILVA", "JOSE@EMAIL.COM", cpf, "1234-1234", true, "assdasdasd");
            //ger.encerrarVisita(cpf);
    }
}
