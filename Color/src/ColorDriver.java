
/*
 * Brandon Russeau
 * COSC 314
 * Programming Assignment 3
 * Driver for Color class
 */
import java.util.Scanner;

public class ColorDriver extends Color {

	private ColorDriver(String file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();

		new Color(file);
		writeColor();

		keyboard.close();
	}
}
