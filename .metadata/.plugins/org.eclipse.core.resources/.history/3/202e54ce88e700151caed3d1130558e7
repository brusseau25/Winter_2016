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
			scanner.nextInt();
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

	public int color() {
		for (int i = 1; i < colorArray.length - 1; i++) {
			if (color(0, i)) {
				return i;
			}
		}
		return 0;
	}

	boolean color(int v, int m) {
		if (v > colorArray.length - 1) {
			return true;
		} else {
			for (int i = 1; i < m; i++) {
				chromaticNum[v] = i;
				if (noConflict(v)) {
					color(v + 1, m);
					return true;
				}
			}
			chromaticNum[v] = 0;
			return false;
		}
	}

	boolean noConflict(int v) {
		for (int i = 0; i < colorArray.length - 1; i++) {
			if (colorArray[v][i] == 1) {
				if (chromaticNum[v] == chromaticNum[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
