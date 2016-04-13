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
	private HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();

	public Customer(int numOrd, double amt, long id) {
		numOrders = numOrd;
		amount = amt;
		customerID = id;
		uniqueID = rn.nextLong();
	}

	public void getLeft() {
		for (int i = 0; i < leftHalf.length; i++) {
			System.out.print(leftHalf[i] + " ");
		}
		System.out.println();
	}

	public void getRight() {
		for (int i = 0; i < rightHalf.length; i++) {
			System.out.print(rightHalf[i] + " ");
		}
		System.out.println();
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

		for (int i = 0; i < rightHalf.length; i++) {
			r1 = rn.nextInt();
			r2 = rn.nextInt();
			// right.put(Integer.toString((rightHalf[i] ^ r1 ^ r2)).hashCode(),
			// r1);
			right.put(hashFunction(rightHalf[i], r1, r2), r1);
		}

		for (int j = 0; j < leftHalf.length; j++) {
			r1 = rn.nextInt();
			r2 = rn.nextInt();
			left.put((hashFunction(leftHalf[j], r1, r2)), r1);
		}
	}

	private int hashFunction(int x, int y, int z) {
		// return Integer.toString(x).hashCode() ^
		// Integer.toString(y).hashCode() ^ Integer.toString(z).hashCode();
		return Integer.toString(x ^ y ^ z).hashCode();
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
		double k = rn.nextDouble();
		double e = rn.nextDouble();
		double n = rn.nextDouble();

		double result = Math.pow(k, e) % n;

		uniqueID = (long) ((uniqueID * result) % n);
		amount = (amount * result) % n;
		for (Integer key : right.keySet()) {
			key = (int) ((key * result) % n);
		}
		for (Integer value : right.values()) {
			value = (int) ((value * result) % n);
		}
		for (Integer key : left.keySet()) {
			key = (int) ((key * result) % n);
		}
		for (Integer value : left.values()) {
			value = (int) ((value * result) % n);
		}

	}

	// Reveal chosen half of identity string
	public int revealHalf(int num, int index) {
		if (num == 0) {
			// reveal leftHalf
			return leftHalf[index];
		} else {
			// reveal rightHalf
			return rightHalf[index];
		}
	}
}
