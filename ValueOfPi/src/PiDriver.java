public class PiDriver extends Pi {
	public static void main(String[] args) {
		int[] randIntArray = new int[5000];

		randIntArray = initIntArray(randIntArray.length);

		calcGCD(randIntArray);

		System.out.printf("Estimate of pi (int array) = %f \n", estimatePI(randIntArray, sumInt));

	}
}
