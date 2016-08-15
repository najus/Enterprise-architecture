/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import week6.entity.Car;

/**
 * 
 * @author najus
 */
public class MyPersister {

    private EntityManagerFactory emf;
    private EntityManager em;
    private static final String puName= "week6PU";

    private EntityTransaction tx;

    public MyPersister() {
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
    
    public List<Car> getAllCars() {
        tx = em.getTransaction();
        Query query = em.createNamedQuery(
                "findAllCar");
        List<Car> list = query.getResultList();
        return list;
    }
    
    public boolean updateCar(Car c) {
        tx = em.getTransaction();
        tx.begin();
        Car car = em.find(Car.class, c.getId());
        car.setColor(c.getColor());
        car.setMake(c.getMake());
        car.setMiles(c.getMiles());
        car.setModel(c.getModel());
        car.setYear(c.getYear());
        tx.commit();
        return true;

    }

    public boolean deleteCar(int id) {
        em.getTransaction();
        tx.begin();
        Car c = em.
                find(Car.class, id);
        em.remove(c);
        em.getTransaction().commit();
        return true;
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
