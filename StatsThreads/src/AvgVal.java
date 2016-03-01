/*
 * Brandon Russeau
 */
public class AvgVal extends Thread {
	static int avg;

	public AvgVal(int[] num) {
		avg = avgVal(num);
	}

	public void run() {
		System.out.println("The average value is " + avg);
	}

	// calculate the average value of a series of numbers
	private int avgVal(int[] num) {
		avg = 0;
		for (int i = 0; i < num.length; i++) {
			avg += num[i];
		}
		avg = avg / num.length;

		return avg;
	}
}
