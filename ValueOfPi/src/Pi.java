import java.util.Random;

public class Pi {

	public static void main(String[] args) {
		Random randNum = new Random();
		int[] randIntArray = new int[1000];
		double gcd;
		int sumInt = 0;
		double sumDoub = 0.0;
		double[] randDoubArray = new double[1000];

		// initialize int array
		for (int i = 0; i < randIntArray.length; i++) {
			randIntArray[i] = randNum.nextInt(100) + 1;
		}

		// initialize double array
		for (int i = 0; i < randDoubArray.length; i++) {
			randDoubArray[i] = Math.random() * 100;
		}

		// find gcd for int array
		for (int j = 0; j < randIntArray.length - 1; j++) {
			gcd = findGCD(randIntArray[j], randIntArray[j + 1]);
			if (gcd == 1.0) {
				sumInt++;
			}
		}

		// find gcd for double array
		for (int j = 0; j < randDoubArray.length - 1; j++) {
			gcd = findGCD((int) randDoubArray[j], (int) randDoubArray[j + 1]);
			if (gcd == 1.0) {
				sumDoub++;
			}
		}

		System.out.printf("Estimate of pi (int array) = %f \n", estimatePI(randIntArray, sumInt));
		System.out.printf("Estimate of pi (double array) = %f \n", estimatePI(randDoubArray, sumDoub));
	}

	/*
	 * code from: http://java67.blogspot.com/2012/08/
	 * java-program-to-find-gcd-of-two-numbers.html
	 */
	private static int findGCD(int x, int y) {
		// base case
		if (y == 0) {
			return x;
		}
		return findGCD(y, x % y);
	}

	private static double estimatePI(int[] matrix, int sum) {
		double PI, num;
		num = (double) sum / matrix.length;
		System.out.println(num);
		PI = Math.sqrt(6.0 / num);

		return PI;
	}

	private static double estimatePI(double[] matrix, double sum) {
		double PI, num;
		num = sum / matrix.length;
		PI = Math.sqrt(6.0 / num);

		return PI;
	}
}
