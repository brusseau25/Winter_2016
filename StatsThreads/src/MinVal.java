/*
 * Brandon Russeau
 */
public class MinVal extends Thread {
	static int min;

	public MinVal(int[] num) {
		min = minVal(num);
	}

	public void run() {
		System.out.println("The minimum value is " + min);
	}

	// calculate the minimum value of a series of numbers
	private int minVal(int[] num) {
		min = num[0];
		for (int i = 1; i < num.length; i++) {
			if (min > num[i])
				min = num[i];
		}

		return min;
	}
}
