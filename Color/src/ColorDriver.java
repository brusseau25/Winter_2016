import java.util.Scanner;

public class ColorDriver extends Color {

	private ColorDriver(String file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String file = null;
		Color colorMatrix = null;

		System.out.print("Enter the name of the file: ");
		file = keyboard.nextLine();

		colorMatrix = new Color(file);
		System.out.println(colorMatrix.color());
		printColor();

		keyboard.close();
	}
}
