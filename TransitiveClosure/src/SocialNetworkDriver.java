
/*
 * Brandon Russeau
 * COSC 314
 */

import java.util.Scanner;

public class SocialNetworkDriver extends WarshallAlgorithm {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();
		int[][] matrix = initializeSocialNetwork(file);
		int[][] transMatrix = warshall(matrix);

		writeTransClosure(transMatrix);

		keyboard.close();
	}

}
