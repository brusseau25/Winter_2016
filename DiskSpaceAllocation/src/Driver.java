import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner io = null;
		int blockSize = 0;
		String option = null;
		String fileName = null;
		int size = 0;

		try {
			io = new Scanner(new File("disk.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blockSize = io.nextInt();
		ContiguousAlloc contAlloc = new ContiguousAlloc(blockSize);
		while (io.hasNextLine()) {
			option = io.next();

			switch (option) {
			case "add":
				fileName = io.next();
				size = io.nextInt();
				contAlloc.add(fileName, size);
				break;
			case "del":

				break;
			case "read":

				break;
			case "print":

				break;
			default:
				break;

			}
		}
	}
}
