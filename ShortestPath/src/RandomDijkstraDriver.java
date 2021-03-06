
/*
 * Brandon Russeau
 * COSC 314
 */
import java.util.Scanner;

public class RandomDijkstraDriver extends DijkstrasAlgorithm {
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

			for (int i = 0; i < 10; i++) {
				random = randomMatrix(size);
				startTime = System.currentTimeMillis();
				dijkstra(random);
				totalTime = System.currentTimeMillis() - startTime;

				System.out.printf("%d %17.2f\n", size, totalTime);
			}
		}

		keyboard.close();
	}
}
