/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import week4.entity.Person;

/**
 * 
 * @author najus
 */
public class MyCRUD {

    private MyPersister myPersister;

    public MyCRUD() {
        this.myPersister = new MyPersister("week4PU");
    }

    public boolean deleteStudent(int id) {
        return myPersister.delete(Person.class, id);
    }

}
