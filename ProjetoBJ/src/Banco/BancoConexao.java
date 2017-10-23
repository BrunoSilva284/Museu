/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

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
   
    public static void salvar(Object e){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}