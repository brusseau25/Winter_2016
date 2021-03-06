
/*
 * Brandon Russeau
 * Ryan Hodgman
 * Isaiah Fuller
 * 
 * COSC 374
 * Estimate the value of PI based on Cesaro's Theorem
 */

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Pi {
	static String file;
	static Random randNum = new Random();
	static double gcd;
	static int sumInt;

	// initialize TRNG array based on input given from a file
	public static int[] initTRNGArray(String file) {
		int[] matrixA = null;
		Scanner scanner = null;
		int num = 5000;
		try {
			scanner = new Scanner(new File(file));

			matrixA = new int[num];
			for (int i = 0; i < matrixA.length; i++) {
				matrixA[i] = scanner.nextInt();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return matrixA;
	}

	// initialize LCG array
	// (uses same modular value as BBS for closer comparison)
	public static int[] initIntArray(int length) {
		int[] matrix = new int[length];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = randNum.nextInt(192649) + 1;
		}
		return matrix;
	}

	// initialize BBS array
	// (uses same modular value as LCG for closer comparison)
	public static long[] generateBBS(long[] arr) {
		long x = 101355;
		long m = 192649;
		for (int i = 0; i < arr.length; i++)
			arr[i] = x = (((long) Math.pow(x, 2)) % m);

		return arr;
	}

	// increments a counter for all relatively prime pairs
	public static void calcGCD(int[] matrix) {
		sumInt = 0;
		// find gcd for int array
		for (int j = 0; j < matrix.length - 1; j++) {
			gcd = findGCD(matrix[j], matrix[j + 1]);
			if (gcd == 1.0) {
				sumInt++;
			}
		}
	}

	// increments a counter for all relatively prime pairs
	public static void calcGCD(long[] matrix) {
		sumInt = 0;
		// find gcd for int array
		for (int j = 0; j < matrix.length - 1; j++) {
			gcd = findGCD((int) matrix[j], (int) matrix[j + 1]);
			if (gcd == 1.0) {
				sumInt++;
			}
		}
	}

	/*
	 * code from: http://java67.blogspot.com/2012/08/
	 * java-program-to-find-gcd-of-two-numbers.html
	 */
	protected static int findGCD(int x, int y) {
		// base case
		if (y == 0) {
			return x;
		}
		return findGCD(y, x % y);
	}

	// estimates the value of pi
	protected static double estimatePI(int[] matrix) {
		double PI, num;
		num = (double) sumInt / matrix.length;
		PI = Math.sqrt(6.0 / num);

		return PI;
	}

	// estimates the value of pi
	protected static double estimatePI(long[] matrix) {
		double PI, num;
		num = (double) sumInt / matrix.length;
		PI = Math.sqrt(6.0 / num);

		return PI;
	}

}
