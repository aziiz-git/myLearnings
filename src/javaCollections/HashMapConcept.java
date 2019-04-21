package javaCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapConcept {

	public static void main(String[] args) {

		HashMap<Integer, String> myHashMapObject = new HashMap<Integer, String>();
		myHashMapObject.put(29, "Selenium");
		myHashMapObject.put(41, "UFT");
		myHashMapObject.put(2, "Test Complete");
		myHashMapObject.put(32, "TOSCA");
		myHashMapObject.put(9, "RFT");
		myHashMapObject.put(11, "RFT");
		
		System.out.println("Value @ key# 41: " + myHashMapObject.get(41));
		System.out.println("Value @ key# 22: " + myHashMapObject.get(22));	// Will return null and no any exception.
		
		// Iteration:
		for(Entry allKeysAndValues : myHashMapObject.entrySet()) {	// Entry is interface
			System.out.println(allKeysAndValues.getKey() + "::" + allKeysAndValues.getValue());
		}
		
		// Remove:
		myHashMapObject.remove(9);	// RFT removed
		System.out.println(myHashMapObject);
		
		// User defined data type example:	
		HashMap <Integer,HashMapConceptEmployee> hashMapConceptEmployee = new HashMap<Integer,HashMapConceptEmployee>();		
		HashMapConceptEmployee emp1 = new HashMapConceptEmployee("Azeez", 22, "QA");
		HashMapConceptEmployee emp2 = new HashMapConceptEmployee("Ryan", 23, "Dev");
		HashMapConceptEmployee emp3 = new HashMapConceptEmployee("Nik", 24, "Ops");
		
		hashMapConceptEmployee.put(1, emp1);
		hashMapConceptEmployee.put(2, emp2);
		hashMapConceptEmployee.put(3, emp3);
		
		// Iteration:
		for(Entry <Integer,HashMapConceptEmployee> allKeysAndValuesFromEmployee : hashMapConceptEmployee.entrySet()) {
			int myKey = allKeysAndValuesFromEmployee.getKey();
			HashMapConceptEmployee myEmployee = allKeysAndValuesFromEmployee.getValue();
			System.out.println("Employee " + myKey + " Info");
			System.out.println(myEmployee.name + " " + myEmployee.age + " " + myEmployee.dept);
		}
		
			}

}
