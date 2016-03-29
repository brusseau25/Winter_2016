
public class MoneyOrder {

	private int ssn;
	private int unqID;

	private int amnt;
	private int[] bankSig = new int[4];
	private int k;
	private int[] randomNum;
	private int[] secretNum;

	public MoneyOrder(int ssn, int uniqueString, int amount) {
		this.ssn = ssn;
		unqID = uniqueString;
		amnt = amount;
		k = (int) ((Math.random() * 7) + 2);
	}

	public String toString() {
		return (ssn + " " + unqID + " " + amnt);
	}

	public int[] getRandomNum() {
		return randomNum;
	}

	public int[] getSecretNum() {
		return secretNum;
	}

	public int getMOID() {
		return unqID;
	}

	public void setMOID(int uniqueID) {
		unqID = uniqueID;
	}

	public int getSSN() {
		return ssn;
	}

	public int getUnqID() {
		return unqID;
	}

	public int getBankSig(int i) {
		return bankSig[i];
	}

	public void setBankSig(int bankSig, int i) {
		this.bankSig[i] = bankSig;
	}

	public int getAmount() {
		return amnt;
	}

	public void setSSN(int i) {
		ssn = i;
	}

	public void setAmount(int i) {
		amnt = i;
	}

	public void setUnqID(int i) {
		unqID = i;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
}
