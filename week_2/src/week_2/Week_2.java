/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import week_2.entity.Car;
import week_2.enums.Color;

/**
 * 
 * @author najus
 */
public class Week_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Car bmw1 = new Car("BMW", "328i", 2016, 1200, Color.RED);
        Car bmw2 = new Car("BMW", "528", 2015, 30000, Color.BLUE);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("week_2PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(bmw1);
        tx.commit();
        
        tx.begin();
        em.persist(bmw2);
        tx.commit();
        
        em.close();
        emf.close();
    }
    
}
