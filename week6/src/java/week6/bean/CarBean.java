/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import week6.entity.Car;
import week6.enums.Color;
import week6.persistence.MyPersister;

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

    public String delete(int id) {
        persister.deleteCar(id);
        return "index";
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
