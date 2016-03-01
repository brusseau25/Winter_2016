
/*
 * Brandon Russeau
 */
import java.util.Scanner;

public class Stats {

	public static void main(String[] args) {
		int[] num = null;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("How many numbers will you be entering? ");
		num = new int[keyboard.nextInt()];

		System.out.println("Enter the series of numbers: ");
		for (int i = 0; i < num.length; i++) {
			num[i] = keyboard.nextInt();
		}

		new MinVal(num).start();
		new MedVal(num).start();
		new MaxVal(num).start();
		new AvgVal(num).start();
		new StdDev(num).start();

		keyboard.close();
	}

}
