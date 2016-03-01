
/*
 * Brandon Russeau
 * COSC 314
 */

import java.util.Scanner;

public class RandomMatrixDriver extends WarshallAlgorithm {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double startTime, totalTime;
		int[][] random = null;
		int size;
		System.out.println("Size of Matrix	Time(milliseconds)");
		for (;;) {
			System.out.print("What size matrix do you want? ");
			size = keyboard.nextInt();
			if (size == -1) {
				System.out.println("Now exiting");
				break;
			}
			random = randomMatrix(size);

			startTime = System.currentTimeMillis();
			warshall(random);
			totalTime = System.currentTimeMillis() - startTime;

			System.out.printf("%d %17.2f\n", size, totalTime);
		}

		keyboard.close();
	}

}
