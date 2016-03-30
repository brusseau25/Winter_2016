import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class fifo {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner scan = null;
	ArrayList<Integer> referenceString = new ArrayList<Integer>();
	int frames, pointer = 0, hit = 0, fault = 0, refLen;
	int[] buffer;
	int[] reference;
	int[][] pages;

	public fifo() {
		try {
			scan = new Scanner(new File("pages.dat"));

			System.out.print("Number of Frames: ");
			frames = scan.nextInt();
			System.out.println(frames);

			int tmp;
			while (scan.hasNextLine()) {
				tmp = scan.nextInt();
				if (tmp != -1) {
					referenceString.add(tmp);
				} else {
					break;
				}
			}

			System.out.print("Length of the Reference string: ");
			refLen = referenceString.size();
			System.out.println(referenceString.size());

			reference = new int[refLen];
			pages = new int[refLen][frames];
			buffer = new int[frames];
			for (int j = 0; j < frames; j++)
				buffer[j] = -1;

			System.out.print("The reference string: ");
			for (int value : referenceString) {
				System.out.print(value + " ");
			}
			System.out.println();

			for (int i = 0; i < refLen; i++) {
				reference[i] = referenceString.get(i);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fifoAlgo() {
		for (

		int i = 0; i < refLen; i++)

		{
			int search = -1;
			for (int j = 0; j < frames; j++) {
				if (buffer[j] == reference[i]) {
					search = j;
					hit++;
					break;
				}
			}
			if (search == -1) {
				buffer[pointer] = reference[i];
				fault++;
				pointer++;
				if (pointer == frames)
					pointer = 0;
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

		System.out.println("\nThe number of Hits: " + hit);
		System.out.println("Hit Ratio: " + (float) ((float) hit / refLen));
		System.out.println("The number of Faults: " + fault);
	}
}