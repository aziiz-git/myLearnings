package javaPracticing;

public class SwapStringsWithoutUsingThirdVariable {

	public static void main(String[] args) {

		String a = "Hello";
		String b = "World";

		System.out.println(":::Before:::");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		a = a + b; // HelloWorld
		b = a.substring(0, a.length() - b.length()); // 0, 10-5 --> b = Hello
		a = a.substring(b.length());  // Only startpoint given

		System.out.println("\n:::After:::");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}
}