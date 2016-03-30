import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PagingAlgorithms {
	private int frames = 0;
	private ArrayList<Integer> referenceString = new ArrayList<Integer>();
	private int pointer = 0;
	private int[][] pages = null;
	private Scanner scan = null;

	public PagingAlgorithms() {
		try {
			scan = new Scanner(new File("pages.dat"));
			frames = scan.nextInt();
			int tmp;
			while (scan.hasNextLine()) {
				tmp = scan.nextInt();
				if (tmp != -1) {
					referenceString.add(tmp);
				} else {
					break;
				}
			}
			pages = new int[referenceString.size()][frames];
			for (int i = 0; i < referenceString.size(); i++) {
				for (int j = 0; j < frames; j++) {
					pages[i][j] = -1;
				}
			}
			for (int value : referenceString) {
				System.out.print(value + " ");
			}
			System.out.println();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fIFO() {
		for (int i = 0; i < referenceString.size(); i++) {
			for (int j = 0; j < frames; j++) {
				if (referenceString.get(i) != pages[i][j]) {
					pages[pointer][j] = referenceString.get(pointer);
				}
				pointer = (pointer + 1) % referenceString.size();
			}
		}

		for (int i = 0; i < frames; i++) {
			for (int j = 0; j < referenceString.size(); j++) {
				System.out.print(pages[j][i] + " ");
			}
			System.out.println();
		}

	}

	public void opt() {

	}

	public void lRU() {

	}

	public void lFU() {

	}

}
