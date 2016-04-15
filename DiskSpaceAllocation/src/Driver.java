
/* Brandon Russeau
 * COSC 423
 */
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
		String regex = "[^\"\\s]+|\"(\\\\.|[^\\\\\"])*\"";

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
				fileName = io.findInLine(regex);
				size = io.nextInt();
				System.out.println(fileName + ": " + size);
				contAlloc.add(fileName, size);
				break;
			case "del":
				fileName = io.findInLine(regex);
				contAlloc.del(fileName);
				break;
			case "read":
				fileName = io.findInLine(regex);
				contAlloc.read(fileName);
				break;
			case "print":
				contAlloc.print();
				break;
			default:
				System.err.println("Error");
				break;
			}
		}
	}
}
