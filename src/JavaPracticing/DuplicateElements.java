package JavaPracticing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {

		String names[] = { "Java", "JavaScript", "Ruby", "python", "C", "Ruby", "Java" };

		// Solution 1: Compare each element:
		// Time Complexity = I have 2 for loops => O(nxn) WORST SOLUTION ACTUALLY

		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {

				if (names[i].equals(names[j])) {
					System.out.println("Duplicate element is :: " + names[i]);
				}
			}
		}

		System.out.println("***********************************************************");

		// Solution 2: Using HashSet (HashSet is part of Java Collection. Stores unique
		// values.)
		// Time Complexity = O(n)

		Set<String> store = new HashSet<String>();
		for (String name : names) {
			if (store.add(name) == false) { // Duplicate --> FALSE
				System.out.println("Duplicate element is :: " + name);
			}
		}

		System.out.println("***********************************************************");

		// Solution 3: Using HashMap. KEY-VALUE PAIR Format
		// Time Complexity = O(2n)

		Map<String, Integer> storeMap = new HashMap<String, Integer>(); // Map is an Interface. HashMap is a class.
																		// Hashmap is implementing Map interface.
		for (String name : names) {
			Integer count = storeMap.get(name);
			if (count == null) {
				storeMap.put(name, 1); // Ocurrence is 1
			} else {
				storeMap.put(name, ++count);
			}
		}
		Set<Entry<String, Integer>> entrySet = storeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate element is :: " + entry.getKey());
			}

		}
	}
}