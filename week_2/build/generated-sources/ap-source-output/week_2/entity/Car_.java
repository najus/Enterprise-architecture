package week_2.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import week_2.enums.Color;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-18T21:31:44")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, Color> color;
    public static volatile SingularAttribute<Car, Integer> year;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, Integer> id;
    public static volatile SingularAttribute<Car, String> make;
    public static volatile SingularAttribute<Car, Integer> miles;

}