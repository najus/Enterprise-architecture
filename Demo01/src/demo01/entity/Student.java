/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo01.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sanja
 */
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false)
    private String name;
    private int age;
    @Column(name="Courses")
    private int coursesTaken;
    private float gpa;
    @Column(length=500)
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(int coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, int coursesTaken, float gpa, String note) {
        this.name = name;
        this.age = age;
        this.coursesTaken = coursesTaken;
        this.gpa = gpa;
        this.note = note;
    }

    
}
