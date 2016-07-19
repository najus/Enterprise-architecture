package demo01.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> note;
	public static volatile SingularAttribute<Student, Integer> coursesTaken;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, Float> gpa;
	public static volatile SingularAttribute<Student, Integer> id;
	public static volatile SingularAttribute<Student, Integer> age;

}

