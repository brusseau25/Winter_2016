
/*
 * Brandon Russeau
 * COSC 314
 * Programming Assignment 3
 * Find the minimum chromatic number of a graph
 * using a brute-force approach
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Color {
	public static int[][] colorArray = null;
	public static int[] chromaticNum = null;
	public static String file = "";

	// initialize adjacency matrix
	public Color(String file) {
		Scanner scanner = null;
		Color.file = file;
		int num = 0;
		int num2 = 0;
		try {
			scanner = new Scanner(new File(file));
			num = scanner.nextInt();
			colorArray = new int[num][num];
			chromaticNum = new int[num];
			num2 = scanner.nextInt();
			while (scanner.hasNextLine()) {
				num = scanner.nextInt();
				num2 = scanner.nextInt();
				colorArray[num - 1][num2 - 1] = 1;
				colorArray[num2 - 1][num - 1] = 1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	// write the vertex and its color to a file
	public static void writeColor() {
		PrintWriter print = null;
		try {
			print = new PrintWriter(file + "Out.txt");
			print.write(color() + "\n");
			for (int j = 0; j < colorArray.length; j++) {
				print.write((j + 1) + " " + chromaticNum[j] + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Your file has been successfully written");
			print.close();
		}

	}

	public static int color() {
		for (int i = 15; i <= colorArray.length; i++) {
			System.out.println("Now attempting to color with " + i + " colors");
			if (color(0, i)) {
				return i;
			}
		}
		return -1;
	}

	static boolean color(int v, int m) {
		if (v == colorArray.length) {
			return true;
		} else {
			for (int i = 1; i <= m; i++) {
				chromaticNum[v] = i;
				if (!isConflict(v)) {
					if (color(v + 1, m))
						return true;
				}
			}
			chromaticNum[v] = 0;
			return false;
		}
	}

	// check neighbors for the same color
	static boolean isConflict(int v) {
		for (int i = 0; i < v; i++) {
			if ((colorArray[v][i] == 1)) {
				if (chromaticNum[v] == chromaticNum[i]) {
					return true;
				}
			}
		}
		return false;
	}
}
