package javaCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	public static <E> void main(String[] args) {

		int a[] = new int[3]; // This a STATIC ARRAY

		ArrayList myArrayList = new ArrayList();

		myArrayList.add(10); // 0th element
		myArrayList.add(true);
		myArrayList.add(30);
		System.out.println("Size of array: " + myArrayList.size());

		myArrayList.add(10);
		myArrayList.add("abc");
		myArrayList.add("$#@"); // Fifth element
		System.out.println("Size of array: " + myArrayList.size());

		System.out.println("Print 2nd element: " + myArrayList.get(2));
		
		// 	Generics:
		//	ArrayList <Integer> myGenericsArrayList = new ArrayList <Integer> (); // We can add only Integer to it.
		//	myGenericsArrayList.add("Hello"); This cannot be added.
			
			ArrayList <E> myGenericsArrayListButNotSureTheType = new ArrayList <E> (); // When we are not sure about the type
			
		/*GENERICS Example using User Defined data type:	*/
		ArrayListConceptEmployee emp1 = new ArrayListConceptEmployee("Azeez", 22, "QA");
		ArrayListConceptEmployee emp2 = new ArrayListConceptEmployee("Ryan", 23, "Dev");
		ArrayListConceptEmployee emp3 = new ArrayListConceptEmployee("Nik", 24, "Ops");
			// Now, create ArrayList:
		ArrayList <ArrayListConceptEmployee> arrayListConceptEmployee = new ArrayList<>(); // The other classname in <> :)
		arrayListConceptEmployee.add(emp1);
		arrayListConceptEmployee.add(emp2);
		arrayListConceptEmployee.add(emp3);		
		
		// How to iterate?
		// 'for' loop:
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}
		
		// 'Iterator' - ArrayListConceptEmployee example used:
		Iterator <ArrayListConceptEmployee> myIterator = arrayListConceptEmployee.iterator();
		while (myIterator.hasNext()) {		// Compare this with LL Iterator
			ArrayListConceptEmployee arrayListConceptEmployeeValues = myIterator.next();	// Extra LOC from LL
			System.out.println("Name: " + arrayListConceptEmployeeValues.name);
			System.out.println("Age: " + arrayListConceptEmployeeValues.age);
			System.out.println("Dept: " + arrayListConceptEmployeeValues.dept);
			System.out.println("\n");
			
			// addAll() method:
			ArrayList myArrayListOne = new ArrayList();
			myArrayListOne.add("@!#");
			myArrayListOne.add(true);
			myArrayListOne.add(22);
			ArrayList myArrayListTwo = new ArrayList();
			myArrayListTwo.add(3);
			myArrayListTwo.add(4);
			myArrayListTwo.add(true);
			
			myArrayListTwo.addAll(myArrayListOne);
			System.out.println("addAll(): " + myArrayListTwo);	// All values in myArrayListOne are added to myArrayListTwo
			
			// removeAll() method:
			myArrayListTwo.removeAll(myArrayListOne);
			System.out.println("removeAll(): " + myArrayListTwo);	// All values in myArrayListOne are removed from myArrayListTwo
			
			// retainAll() method:
			myArrayListTwo.add(22);
			myArrayListTwo.retainAll(myArrayListOne);
			System.out.println("retainAll(): " + myArrayListTwo);	// Intersection
			
		}
	}

}