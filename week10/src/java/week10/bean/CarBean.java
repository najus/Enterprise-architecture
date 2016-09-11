/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import week10.entity.Car;
import week10.enums.Color;
import week10.persistence.MyPersister;

/**
 *
 * @author najus
 */
@ManagedBean
@RequestScoped
public class CarBean {

    @ManagedProperty(value = "#{car}")
    Car car;
    MyPersister persister = new MyPersister();

    public CarBean() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String add() {
        persister.persist(car);
        car = null;
        return "index";
    }

    public Color[] getColors() {
        return Color.values();
    }

    public List<Car> getAllCars() {
        return persister.getAllCars();

    }

    public String showUpdatePage(Car c) {
        car = c;
        return "updateCar";
    }

    public String update() {
        persister.updateCar(car);
        car = null;
        return "index";
    }
}
