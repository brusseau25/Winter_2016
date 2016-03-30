import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Customer {
	// variables
	private int numOrders;
	private double amount;
	private long customerID;
	private long uniqueID;
	private int[] leftHalf = new int[10];
	private int[] rightHalf = new int[10];
	private Random rn = new Random();
	private HashMap<Integer, Integer> right;
	private HashMap<Integer, Integer> left;

	public Customer(int numOrd, double amt, long id) {
		numOrders = numOrd;
		amount = amt;
		customerID = id;
		uniqueID = rn.nextLong();
	}

	public String getInfo() {
		return customerID + " " + numOrders + " " + amount;
	}

	// Generate N money orders and assign a different random uniqueness string
	// number for each of the N ecash money orders

	// Secret splitting
	public void sercretSplit() {
		for (int i = 0; i < 10; i++) {
			rightHalf[i] = rn.nextInt();
			leftHalf[i] = (int) (customerID ^ rightHalf[i]);
		}
	}

	// Bit commitment
	public void bitCommitment() {
		int r1 = 0;
		int r2 = 0;
		int l1 = 0;
		int l2 = 0;

		for (int i = 0; i < rightHalf.length; i++) {
			r1 = rn.nextInt();
			r2 = rn.nextInt();
			right.put(((rightHalf[i] ^ r1 ^ r2) % 229), r1);
		}

		for (int i = 0; i < leftHalf.length; i++) {
			l1 = rn.nextInt();
			l2 = rn.nextInt();
			right.put(Integer.toString((leftHalf[i] ^ l1 ^ l2)).hashCode(), l1);
		}
	}

	public void getIDs() {
		// Get a set of the entries
		Set<Entry<Integer, Integer>> leftSet = left.entrySet();
		Set<Entry<Integer, Integer>> rightSet = right.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, Integer>> l = leftSet.iterator();
		Iterator<Entry<Integer, Integer>> r = rightSet.iterator();
		// Display elements
		while (l.hasNext()) {
			Map.Entry me = (Map.Entry) l.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		while (r.hasNext()) {
			Map.Entry me = (Map.Entry) r.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}

	// Blind signature protocol
	public void blind() {

	}

	// Reveal chosen half of identity string
	public void revealHalf() {

	}
}
