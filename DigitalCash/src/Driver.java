import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int orders;
		double amount;
		long id;

		System.out.println("Please enter your id");
		id = keyboard.nextLong();
		System.out.println("Please enter your the number of money orders");
		orders = keyboard.nextInt();
		System.out.println("Please enter the amount");
		amount = keyboard.nextDouble();

		Customer alice = new Customer(orders, amount, id);
		System.out.println(alice.getInfo());

		alice.sercretSplit();
		alice.bitCommitment();
		alice.getIDs();
	}
}
