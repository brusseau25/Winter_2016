
/*
 * Brandon Russeau
 * COSC 314
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FloydsAlgorithm {
	static String file;

	// initialize array based on user input given from a file
	public static int[][] initializeMatrix(String file) {
		int[][] matrixA = null;
		Scanner scanner = null;
		FloydsAlgorithm.file = file;
		int num = 0;
		try {
			scanner = new Scanner(new File(file));

			num = scanner.nextInt();
			matrixA = new int[num][num];
			for (int i = 0; i < matrixA.length; i++) {
				for (int j = 0; j < matrixA.length; j++) {
					matrixA[i][j] = scanner.nextInt();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return matrixA;
	}

	// perform floyds algorithm on matrix to produce the shortest path
	public static int[][] floyd(int[][] matrixA) {
		int[][] matrixB = new int[matrixA.length][matrixA.length];
		for (int k = 0; k < matrixA.length; k++) {
			for (int i = 0; i < matrixA.length; i++) {
				for (int j = 0; j < matrixA.length; j++) {
					if (matrixA[i][j] == 0 && i != j)
						matrixA[i][j] = 999999999;
					if (matrixA[i][k] + matrixA[k][j] < matrixA[i][j]) {
						matrixA[i][j] = matrixA[i][k] + matrixA[k][j];
						matrixB[i][j] = k;
					}
				}
			}
		}
		return matrixA;
	}

	// initialize a random matrix with values 1-1000
	public static int[][] randomMatrix(int size) {
		int[][] randomMatrix = new int[size][size];
		for (int i = 0; i < randomMatrix.length; i++) {
			for (int j = 0; j < randomMatrix.length; j++) {
				randomMatrix[i][j] = (int) (Math.random() * 1000) + 1;
			}
		}
		return randomMatrix;
	}

	// write shortest path to a file
	public static void writeShortestPath(int[][] matrixA) {
		PrintWriter print = null;
		try {
			print = new PrintWriter(file + "Out.txt");
			print.write(matrixA.length + "\n");
			for (int i = 0; i < matrixA.length; i++) {
				for (int j = 0; j < matrixA.length; j++) {
					print.write(matrixA[i][j] + " ");
				}
				print.write("\n");
			}
			System.out.println("Your file has been successfully written");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			print.close();
		}

	}

	// display the matrix
	public static void printMatrix(int[][] matrixA) {
		System.out.println(matrixA.length);
		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA.length; j++) {
				System.out.print(matrixA[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
