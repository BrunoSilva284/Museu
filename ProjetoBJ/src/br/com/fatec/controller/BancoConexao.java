/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class BancoConexao {
     /**
     * Connect to a sample database
     * @param e
     */
   //criar variaveis
    private static String usuario = "root";
    private static String senha = "root";
    private static String servidor = "localhost";
    private static String bd = "museu";
    private static int porta = 3306;
    
    //variavel de conexao
    private static Connection conexao = null;
    
    public static void salvar(Object e){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static void atualizar(Object e){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static <T extends Object> T buscar(Class<T> classe, Object parametro_busca){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Object busca = em.find(classe, parametro_busca);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        return (T) busca;
    }
    
    public static void conectar() throws ClassNotFoundException, SQLException{
              String url = "jdbc:mysql://" +
                servidor + 
                ":" + porta +
                "/" + bd;
        
        //carrega o driver do banco
        Class.forName("com.mysql.jdbc.Driver");
        //Faz a conexao com o banco
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    public static void desconectar() throws SQLException{
        conexao.close();
    }
    
    public static Connection getConexao() {
        return conexao;
    }
    
    
    
}