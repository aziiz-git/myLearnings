package javaPracticing;

public class FirstTwoMaxValues {
	public void GetTwoMaxValues(int[] nums) {

		int maxOne = 0;
		int maxTwo = 0;

		for (int n : nums) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}
		}

		System.out.println("Max# 1: " + maxOne);
		System.out.println("Max# 2: " + maxTwo);
	}

	public static void main(String[] args) {

		int list[] = { 15, 24, 22, 88 };

		FirstTwoMaxValues max = new FirstTwoMaxValues();
		max.GetTwoMaxValues(list);
	}
}