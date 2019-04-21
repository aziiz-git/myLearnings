package javaCollections;

public class ArrayListConceptEmployee {

	String name;
	int age;
	String dept;

	ArrayListConceptEmployee(String name, int age, String dept) { // Constructor

		this.name = name; // Initalizing the global class variables. If global and local has same name, we
							// need to use 'this'.
		this.age = age;
		this.dept = dept;

	}

}