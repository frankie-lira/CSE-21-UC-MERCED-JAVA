import java.util.Random;
import java.util.Scanner;

public class Error {

	public static void main(String[] args) {

		final int MAXCHEESE = 20;

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		// Three Special Cheeses
		names[0] = "Humboldt Fog";
		prices[0] = 25.00;

		names[1] = "Red Hawk";
		prices[1] = 40.50;

		names[2] = "Teleme";
		prices[2] = 17.25;

		Scanner kbd = new Scanner(System.in);

		int NumCheese = 0;
		System.out.print("Enter the number of Cheeses for shop setup:");
		NumCheese = kbd.nextInt();

		System.out.println("We sell " + NumCheese + " kinds of Cheese: (in 0.5 lb packages)");
		Random ranGen = new Random(100);
		int i;
		for (i = 0; i < NumCheese; i++)
			if (i < 3)
					System.out.println(names[i] + ": $" + prices[i] + " per pound");

			if (i >= 3)
				for (int g1 = 3; g1 < NumCheese; g1++) {
					names[g1] = "Cheese Type " + (char) ('A' + g1);
					prices[g1] = ranGen.nextInt(1000) / 100.0;
					amounts[g1] = 0;
					System.out.println(names[g1] + ": $" + prices[g1] + " per pound");
				}
	}

}
