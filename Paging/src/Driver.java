import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = null;
		ArrayList<Integer> referenceString = new ArrayList<Integer>();
		int frames;

		try {
			scan = new Scanner(new File("pages.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		FIFO p = new FIFO(referenceString, frames);
		p.fifoAlgo();

		LRU q = new LRU(referenceString, frames);
		q.lruAlgo();

		Optimal s = new Optimal(referenceString, frames);
		s.optimalAlgo();

	}

}
