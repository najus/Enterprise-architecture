 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import week10.enums.Color;

/**
 *
 * @author najus
 */
@Entity
@Table(name = "CarTbl")
@ManagedBean
@RequestScoped
@NamedQueries({
    @NamedQuery(query = "SELECT c FROM Car c",
            name = "findAllCar"),
    @NamedQuery(query = "SELECT COUNT(c) FROM Car c", name = "countCar")
})

public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private String make;
    private String model;
    @Column(name = "ManufacturingYear")
    private int year;
    private int miles;
    @Enumerated(EnumType.STRING)
    private Color color;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Car() {
    }

    public Car(String make, String model, int year, int miles, Color color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
        this.color = color;
    }

    @PostUpdate
    private void postUpdateCall() {
        System.out.println("Car with id : " + this.getId() + " is updated.");
    }

}
