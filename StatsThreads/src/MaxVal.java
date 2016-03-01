/*
 * Brandon Russeau
 */
public class MaxVal extends Thread {
	static int max;

	public MaxVal(int[] num) {
		max = maxVal(num);
	}

	public void run() {
		System.out.println("The maximum value is " + max);
	}

	// calculate the maximum value of a series of numbers
	private int maxVal(int[] num) {
		max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (max < num[i])
				max = num[i];
		}

		return max;
	}

}
