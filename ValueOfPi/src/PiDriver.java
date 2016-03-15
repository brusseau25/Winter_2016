/*
 * Brandon Russeau
 * Ryan Hodgman
 * Isaiah Fuller
 * 
 * COSC 374
 * Estimate the value of PI based on Cesaro's Theorem
 */

public class PiDriver extends Pi {
	public static void main(String[] args) {
		int[] randIntArray = new int[5000];
		int[] trngNum = new int[5000];
		double piAverageTRNG = 0.0;
		double piAvgInt = 0.0;
		int size = 15;

		for (int i = 1; i < (size + 1); i++) {
			trngNum = initTRNGArray("test" + i + ".txt");
			calcGCD(trngNum);
			piAverageTRNG += estimatePI(trngNum);
		}
		piAverageTRNG /= size;
		System.out.printf("Estimate of pi (trng array) = %f \n", piAverageTRNG);

		for (int i = 1; i < (size + 1); i++) {
			randIntArray = initIntArray(randIntArray.length);
			calcGCD(randIntArray);
			piAvgInt += estimatePI(randIntArray);
		}
		piAvgInt /= size;
		System.out.printf("Estimate of pi (int array) = %f \n", piAvgInt);

	}
}