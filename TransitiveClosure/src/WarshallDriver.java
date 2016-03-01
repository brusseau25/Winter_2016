
/*
 * Brandon Russeau
 * COSC 314
 */

import java.util.Scanner;

public class WarshallDriver extends WarshallAlgorithm {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();
		int[][] matrix = initializeMatrix(file);
		int[][] transMatrix = null;
		transMatrix = warshall(matrix);
		writeTransClosure(transMatrix);

		keyboard.close();
	}
}
