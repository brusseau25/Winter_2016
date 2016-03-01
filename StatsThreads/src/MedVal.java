
/*
 * Brandon Russeau
 */
import java.util.Arrays;

public class MedVal extends Thread {
	static double medVal;

	public MedVal(int[] num) {
		medVal = medVal(num);
	}

	public void run() {
		System.out.println("The median is " + medVal);
	}

	// calculate the median of a series of numbers
	private double medVal(int[] num) {
		Arrays.sort(num);
		if (num.length % 2 == 0)
			medVal = ((double) num[num.length / 2] + (double) num[num.length / 2 - 1]) / 2;
		else
			medVal = (double) num[num.length / 2];

		return medVal;
	}
}
