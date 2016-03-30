import java.util.ArrayList;
import java.util.Scanner;

public class LRU {
	// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int frames, pointer = 0, fault = 0, refLen;
	Boolean isFull = false;
	Scanner scan = null;
	int buffer[];
	ArrayList<Integer> referenceString = new ArrayList<Integer>();
	int reference[];
	int pages[][];

	public LRU(ArrayList<Integer> referenceString, int frames) {

		this.frames = frames;

		refLen = referenceString.size();

		reference = new int[refLen];
		pages = new int[refLen][frames];
		buffer = new int[frames];
		for (int j = 0; j < frames; j++)
			buffer[j] = -1;

		System.out.println("LRU: ");
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

	public void lruAlgo() {
		for (

		int i = 0; i < refLen; i++)

		{
			if (referenceString.contains(reference[i])) {
				referenceString.remove(referenceString.indexOf(reference[i]));
			}
			referenceString.add(reference[i]);
			int search = -1;
			for (int j = 0; j < frames; j++) {
				if (buffer[j] == reference[i]) {
					search = j;
					break;
				}
			}
			if (search == -1) {
				if (isFull) {
					int min_loc = refLen;
					for (int j = 0; j < frames; j++) {
						if (referenceString.contains(buffer[j])) {
							int temp = referenceString.indexOf(buffer[j]);
							if (temp < min_loc) {
								min_loc = temp;
								pointer = j;
							}
						}
					}
				}
				buffer[pointer] = reference[i];
				fault++;
				pointer++;
				if (pointer == frames) {
					pointer = 0;
					isFull = true;
				}
			}
			for (int j = 0; j < frames; j++)
				pages[i][j] = buffer[j];
		}

		for (

		int i = 0; i < frames; i++)

		{
			for (int j = 0; j < refLen; j++)
				System.out.printf("%3d ", pages[j][i]);
			System.out.println();
		}

		System.out.println("\nThe number of Faults: " + fault + "\n");
	}
}