/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import week4.entity.Laptop;
import week4.entity.Notebook;
import week4.entity.Person;
import week4.entity.Student;
import week4.entity.Teacher;

/**
 * 
 * @author najus
 */
public class Week4 {   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Student jack = new Student("jacky", 3.4f);
        Student john = new Student("john", 3.2f);
        Student jill = new Student("jill", 3.6f);
        Teacher jim = new Teacher("jim", 45000);
        Teacher jasmin = new Teacher("jasmin", 46000);
        
        jack.addNotebooks(new Notebook(100));
        jack.addNotebooks(new Notebook(120));
        jack.addNotebooks(new Notebook(60));
        john.addNotebooks(new Notebook(200));
        john.addNotebooks(new Notebook(50));
        jill.addNotebooks(new Notebook(300));
        
        jim.setLaptop(new Laptop("dell"));
        jasmin.setLaptop(new Laptop("mac"));        
        
        //persisting objects
        MyPersister myPersister = new MyPersister("week4PU");
        myPersister.<Person>persist(jack);
        myPersister.<Person>persist(john);
        myPersister.<Person>persist(jill);
        myPersister.<Person>persist(jim);
        myPersister.<Person>persist(jasmin);
        
        //deleting student of id 3
        MyCRUD myCRUD = new MyCRUD();
        System.out.println(myCRUD.deleteStudent(3));
        
        
    }
    
}
