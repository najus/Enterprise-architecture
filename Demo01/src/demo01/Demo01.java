/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo01;

import demo01.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sanja
 */
public class Demo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student jack = new Student("Jack", 25, 5, 3.3f, "This is jack");
        Student tom = new Student("Tom", 27, 6, 3.9f, "This is Tom");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demo01PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();        
        em.persist(jack);
        tx.commit();
        
        tx.begin();        
        em.persist(jack);
        tx.commit();
        
        em.close();
        emf.close();
        

    }
    
}
