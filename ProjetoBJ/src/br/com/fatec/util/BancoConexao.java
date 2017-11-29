package br.com.fatec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
 
/**
 *
 * @author aluno
 */
public class BancoConexao {
    private static final String usuario = "root";
    private static final String senha = "root";
    private static final String servidor = "localhost";
    private static final String bd = "museu";
    private static final int porta = 3306;

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
    
    
    public static void remover(Object e, Object parametro_busca){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object remover = em.find(e.getClass(), parametro_busca);
        em.remove(remover);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static <T extends Object>T buscarLista(String jpql){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("museu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(jpql);

        List<T> resultados = query.getResultList(); 
        
        em.getTransaction().commit();
        em.close();
        return (T) resultados;
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
                "/" + bd +"?autoReconnect=true&useSSL=false";
        
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