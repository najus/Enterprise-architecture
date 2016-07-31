/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 * @author najus
 */
public class MyPersister {

    private EntityManagerFactory emf;
    private EntityManager em;

    private EntityTransaction tx;

    public MyPersister(String puName) {
        init(puName);
    }

    private void init(String puName) {
        this.emf = Persistence.createEntityManagerFactory(puName);
        this.em = emf.createEntityManager();
    }

    private void start(String puName) {
        if (em == null) {
            init(puName);
        }
    }

    public <T> void persist(T t) {
        tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
    }

    public <T> T get(Class<T> t, int id) {
        return em.find(t, id);
    }

    public <T> boolean delete(Class<T> t, int id) {
        T loadedT = get(t, id);
        if (loadedT != null) {
            tx = em.getTransaction();
            tx.begin();
            em.remove(loadedT);
            tx.commit();
            return true;
        }
        return false;
    }

    private void close() {
        em = null;
        em.close();
        emf.close();
    }
}
