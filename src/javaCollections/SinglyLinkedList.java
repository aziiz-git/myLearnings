package javaCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class SinglyLinkedList {

	public static void main(String[] args) {

		LinkedList <String> ll = new LinkedList<String>();

		// Add:
		ll.add("Test");
		ll.add("UFT");
		ll.add("Selenium");
		ll.add("RFT");
		ll.add("Tosca");
		System.out.println("Contents of LinkedList: " + ll);

		// Addfirst and Addlast:
		ll.addFirst("WorksoftCertify");
		ll.addLast("KatalonStudio");
		System.out.println("Contents of LinkedList: " + ll);

		// Get:
		System.out.println("Content of LinkedList at 0th Index: " + ll.get(0));

		// Set:
		ll.set(1, "Cucumber");
		System.out.println("Contents of LinkedList: " + ll);

		// Remove first and last elements:
		ll.removeFirst();
		ll.removeLast();
		System.out.println("Contents of LinkedList: " + ll);

		// Remove from specific position:
		ll.remove(2);
		System.out.println("Contents of LinkedList: " + ll);

		// Iteration:
		System.out.println("\n\n********** ITERATION **********");
		// 1. Using for loop:
		System.out.println("\nUsing 'for' loop:");
		for (int n = 0; n < ll.size(); n++) {
			System.out.println(ll.get(n));
		}

		// 2. Using Advanced for loop:
		System.out.println("\nUsing Advanced 'for' loop:");
		for (String str : ll) {
			System.out.println(str);
		}

		// 3. Using Iterator:
		System.out.println("\nUsing Iterator:");	// Iterator + while + hasNext()
		Iterator <String> myIterator = ll.iterator(); // Iterator reference
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}

		// 4. Using while loop:
		System.out.println("\nUsing 'while' loop:");
		int num = 0;
		while (ll.size() > num) {
			System.out.println(ll.get(num));  // Numbering is sequential. That's why.
			num++;
		}
	}
}