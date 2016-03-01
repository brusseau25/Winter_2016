
/*
 * Brandon Russeau
 * COSC 314
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class WarshallAlgorithm {
	static String file;

	// initialize array based on user input given from a file
	public static int[][] initializeMatrix(String file) {
		int[][] matrixA = null;
		Scanner scanner = null;
		WarshallAlgorithm.file = file;
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

	// perform warshall algorithm on matrix to produce the transitive closure
	public static int[][] warshall(int[][] matrix) {
		int[][] matrixB = new int[matrix.length][matrix.length];
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrixB[i][j] = matrix[i][j] | (matrix[i][k] & matrix[k][j]);
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = matrixB[i][j];
				}
			}
		}
		return matrix;
	}

	// initialize a random matrix for part one of the assignment
	public static int[][] randomMatrix(int size) {
		int[][] randomMatrix = new int[size][size];
		Random randomGen = new Random();
		for (int i = 0; i < randomMatrix.length; i++) {
			for (int j = 0; j < randomMatrix.length; j++) {
				if (randomGen.nextDouble() < 0.5)
					randomMatrix[i][j] = 1;
				else
					randomMatrix[i][j] = 0;
			}
		}
		return randomMatrix;
	}

	// initialize a random matrix for part three of the assignment
	public static int[][] randomMatrix(int size, double prob, long seed) {
		int[][] randomMatrix = new int[size][size];
		Random randomGen = new Random(seed);
		for (int i = 0; i < randomMatrix.length; i++) {
			for (int j = 0; j < randomMatrix.length; j++) {
				if (randomGen.nextDouble() < prob)
					randomMatrix[i][j] = 1;
				else
					randomMatrix[i][j] = 0;
			}
		}
		return randomMatrix;
	}

	// display the matrix
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// write transitive closure to a file
	public static void writeTransClosure(int[][] matrix) {
		PrintWriter print = null;
		try {
			print = new PrintWriter(file + "Out.txt");
			print.write(matrix.length + "\n");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					print.write(matrix[i][j] + " ");
				}
				print.write("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Your file has been successfully written");
			print.close();
		}

	}

	// initialize array based on user input given from a file
	public static int[][] initializeSocialNetwork(String file) {
		WarshallAlgorithm.file = file;
		int[][] socialNetwork = null;
		int size, row, col;
		Scanner scanFile = null;

		try {
			scanFile = new Scanner(new File(file));
			size = scanFile.nextInt();
			socialNetwork = new int[size][size];
			scanFile.nextInt();

			while (scanFile.hasNext()) {

				row = scanFile.nextInt();
				col = scanFile.nextInt();

				socialNetwork[row - 1][col - 1] = 1;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanFile.close();
		}

		return socialNetwork;
	}

	// calculate the average percentage of one's in the transitive closure
	public static double percentage(int[][] matrix) {
		double percentage = 0.0;
		double numOfOnes = 0.0;
		double total = matrix.length * matrix.length;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					numOfOnes += 1.0;
				}
			}
		}

		percentage = (numOfOnes / total) * 100;

		return percentage;
	}
}
