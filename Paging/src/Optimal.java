
/*
 * Brandon Russeau
 * COSC 423
 * Virtual Memory Page Replacement Project
 * Optimal Replacement algorithm
 */

import java.util.ArrayList;

public class Optimal {
	int frames, pointer = 0, fault = 0, refLen;
	boolean isFull = false;
	int buffer[];
	int reference[];
	int pages[][];

	public Optimal(ArrayList<Integer> referenceString, int frames) {

		this.frames = frames;

		refLen = referenceString.size();

		reference = new int[refLen];
		pages = new int[refLen][frames];
		buffer = new int[frames];
		for (int j = 0; j < frames; j++)
			buffer[j] = -1;

		System.out.println("Optimal: ");
		System.out.print("The reference string: ");
		for (int value : referenceString) {
			System.out.print(value + " ");
		}
		System.out.println();

		for (int i = 0; i < refLen; i++) {
			reference[i] = referenceString.get(i);
		}
		System.out.println();
	}

	public int getFaults() {
		return this.fault;
	}

	public void optimalAlgo() {
		for (int i = 0; i < refLen; i++) {
			int search = -1;
			for (int j = 0; j < frames; j++) {
				if (buffer[j] == reference[i]) {
					search = j;
					break;
				}
			}
			if (search == -1) {
				if (isFull) {
					int index[] = new int[frames];
					boolean flag[] = new boolean[frames];
					for (int j = i + 1; j < refLen; j++) {
						for (int k = 0; k < frames; k++) {
							if ((reference[j] == buffer[k]) && (flag[k] == false)) {
								index[k] = j;
								flag[k] = true;
								break;
							}
						}
					}
					int max = index[0];
					pointer = 0;
					if (max == 0)
						max = 200;
					for (int j = 0; j < frames; j++) {
						if (index[j] == 0)
							index[j] = 200;
						if (index[j] > max) {
							max = index[j];
							pointer = j;
						}
					}
				}
				buffer[pointer] = reference[i];
				fault++;
				if (!isFull) {
					pointer++;
					if (pointer == frames) {
						pointer = 0;
						isFull = true;
					}
				}
			}
			for (int j = 0; j < frames; j++)
				pages[i][j] = buffer[j];
		}

		if (refLen > 80) {
			for (int i = 0; i < frames; i++) {
				for (int j = 0; j < 78; j++)
					System.out.printf("%3d ", pages[j][i]);
				System.out.println();
			}

			System.out.println();
			for (int i = 0; i < frames; i++) {
				for (int j = 78; j < refLen; j++)
					System.out.printf("%3d ", pages[j][i]);
				System.out.println();
			}

		} else {
			for (int i = 0; i < frames; i++) {
				for (int j = 0; j < refLen; j++)
					System.out.printf("%3d ", pages[j][i]);
				System.out.println();
			}
		}
		System.out.println("Page Faults: " + fault);
		System.out.println();
	}
}
