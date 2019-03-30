package JavaPracticing;

public class FindMissingNumber {

	public static void main(String[] args) {

		int a[] = {1, 2, 3, 4, 5, 7};

		// 1 + 2 + 3 + 4 + 5 + 7 = 22

		// 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28

		// 28 - 22 = 6

		int sum1 = 0;
		for (int i = 0; i < a.length; i++) {
			sum1 = sum1 + a[i];
		}
		System.out.println(sum1);

		int sum2 = 0;
		for (int j = 1; j <= 7; j++) {
			sum2 = sum2 + j;
		}
		System.out.println(sum2);

		System.out.println("Missing number is ::: " + (sum2 - sum1));

	}

}
