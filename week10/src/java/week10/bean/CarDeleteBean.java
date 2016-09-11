/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import week10.entity.Car;
import week10.persistence.MyPersister;

/**
 *
 * @author najus
 */
@ManagedBean
@RequestScoped
public class CarDeleteBean {

    private List<Car> cars;
    private int numberOfCars;
    MyPersister persister;

    public CarDeleteBean() {
        persister = new MyPersister();
        cars = persister.getAllCars();
        numberOfCars = persister.getCarsCount();
    }

    public List<Car> getCar() {
        return cars;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public String delete(int id) {
        persister.delete(Car.class, id);
        return "index";
    }

}
