/*
 * Brandon Russeau
 */
public class StdDev extends Thread {
	static double sd = 0;

	public StdDev(int[] num) {
		sd = stdDev(num);
	}

	public void run() {
		System.out.println("The standard deviation is " + sd);
	}

	// calculate the standard deviation of a series of numbers
	private double stdDev(int[] num) {
		for (int i = 0; i < num.length; i++) {
			sd += Math.pow((num[i] - AvgVal.avg), 2) / num.length;
		}

		sd = Math.sqrt(sd);

		return sd;
	}
}
