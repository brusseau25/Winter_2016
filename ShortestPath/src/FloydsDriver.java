
/*
 * Brandon Russeau
 * COSC 314
 */
import java.util.Scanner;

public class FloydsDriver extends FloydsAlgorithm {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();
		int[][] matrix = initializeMatrix(file);
		int[][] shortestPath = null;
		shortestPath = floyd(matrix);
		writeShortestPath(shortestPath);

		keyboard.close();

//added a comment on this line
	}
}
