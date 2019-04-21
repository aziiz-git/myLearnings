package javaPracticing;

public class RemoveJunk {

	public static void main(String[] args) {

		String myString = "中國哲學書電�?化計劃 Hello World 09843211234890";

		System.out.println("My String before: " + myString);

		// We use Regular expression. [^a-zA-Z0-9]

		myString = myString.replaceAll("[^a-zA-Z0-9]", ""); // ^ means all other; Chars other than a-z, A-Z & 0-9 will
															// be replaced with ""

		System.out.println("My String after: " + myString);

	}

}
