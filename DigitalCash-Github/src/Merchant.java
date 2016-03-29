
public class Merchant {

	public boolean verifyBankSigniture(String signatureList[], MoneyOrder MO) {
		for (int i = 0; i < signatureList.length; i++) {
			if (signatureList[i].equals(Integer.toString(MO.getMOID()))) {
				return true;
			}
		}
		return false;
	}

	public int randomSelectorBit() {
		return ((int) ((Math.random()) * 10) % 2);
	}
}
