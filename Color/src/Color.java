import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Color {
	public static int[][] colorArray = null;
	public static int[] chromaticNum = null;

	public Color(String file) {
		Scanner scanner = null;
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
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void print() {
		for (int i = 0; i < colorArray.length; i++) {
			for (int j = 0; j < colorArray.length; j++) {
				System.out.print(colorArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printColor() {
		for (int j = 0; j < colorArray.length; j++) {
			System.out.println((j + 1) + " " + chromaticNum[j]);
		}
	}

	public int color() {
		for (int i = 0; i < colorArray.length; i++) {
			if (color(0, i)) {
				return i;
			}
		}
		return -1;
	}

	boolean color(int v, int m) {
		if (v > (colorArray.length - 1)) {
			return true;
		} else {
			for (int i = 0; i <= m; i++) {
				chromaticNum[v] = i;
				if (!isConflict(v)) {
					color(v + 1, m);

					if (isFinished())
						return true;
				} else {
					chromaticNum[v] = 0;
				}
			}
			return false;
		}
	}

	boolean isConflict(int v) {
		for (int i = 0; i < colorArray.length; i++) {
			if ((colorArray[v][i] == 1)) {
				if (chromaticNum[v] == chromaticNum[i]) {
					return true;
				}
			}
		}
		return false;
	}

	boolean isFinished() {
		for (int i = 0; i < chromaticNum.length; i++) {
			if (isConflict(i) || chromaticNum[i] == 0)
				return false;
		}
		return true;
	}
}
