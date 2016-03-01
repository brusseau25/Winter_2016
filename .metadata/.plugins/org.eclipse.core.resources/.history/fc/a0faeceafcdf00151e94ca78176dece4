import java.util.Scanner;

public class DijkstraDriver extends DijkstrasAlgorithm {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();
		int[][] matrix = initializeMatrix(file);

		dijkstra(matrix);
		writeShortestPath(matrix, file);

		keyboard.close();
	}

}
