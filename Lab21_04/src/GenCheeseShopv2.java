import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold while
	 * populating the names and prices arrays, and initializing the amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts, int MAXCHEESE) {
		// Fill-in

		

		if (0 < names.length && names.length < 21) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if (1 < names.length) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if (2 < names.length) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
		System.out.println(" ");
		System.out.println("We sell " + names.length + " kinds of cheese (in 0.5 lb packages)");

		if (0 < names.length && names.length < 21)
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		if (1 < names.length)
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		if (2 < names.length)
			System.out.println(names[2] + ": $" + prices[2] + " per pound");

		Random ranGen = new Random(100);
		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char) ('A' + i);
			prices[i] = ranGen.nextInt(1000) / 100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

		System.out.println(" ");
	}

	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		for (int i = 0; i < amounts.length; i++) {

			System.out.print("Enter the amount of " + names[i] + " in lb: ");
			amounts[i] = sc.nextDouble();

			while ((amounts[i] % 0.5 != 0) || (amounts[i] < 0)) {

				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				amounts[i] = sc.nextDouble();

				if (amounts[i] < 0) {
					System.out.print("Invalid input. Enter a value >= 0:");
					amounts[i] = sc.nextDouble();
				}

				if (amounts[i] % 0.5 != 0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[i] = sc.nextDouble();
				}
			}

			/*
			 * double OP = amounts[i] * prices[i]; Oprice[i] = OP;
			 */
		}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		int SubtotalCount = 0;

		for (int i = 0; i < amounts.length; i++) {
			SubtotalCount += amounts[i];
		}
		for (int i = 0; i < names.length; i++) {
			if (amounts[i] > 0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f \n", amounts[i], names[i], prices[i],
						amounts[i] * prices[i]);
			}
		}
		if (names.length > 0 && SubtotalCount == 0) {
			System.out.println("No Items were purchased.");
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each cheese
	 * added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix
		double subTotal = 0;

		for (int i = 0; i < amounts.length; i++)
			subTotal += (amounts[i] * prices[i]);
		return subTotal;

	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk,
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array.
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices) {
		// Fix
		double[] disSpecials = new double[amounts.length];
		if (amounts.length > 0) {
			// Humbolt Fog
			disSpecials[0] = ((prices[0]) * ((int) amounts[0]) / 2);
			// Red Hawk
			if (amounts.length > 1)
				disSpecials[1] = ((int) (amounts[1] / 1.5) * 20.25);

		}
		return disSpecials;
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		System.out.printf("\n\nOriginal Sub Total: 		  $%.2f\n", subTotal);

		System.out.println("Specials...  ");
		if (disSpecials.length > 0 && disSpecials[0] > 0) {
			System.out.printf("Humbolt fog (Buy 1 Get 1 Free):  -$%.2f\n", disSpecials[0]);
			subTotal -= disSpecials[0];
		}
		if (disSpecials.length > 1 && disSpecials[1] > 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free):     -$%.2f\n", disSpecials[1]);
			subTotal -= disSpecials[1];
		}
		if (disSpecials.length < 0 || subTotal == 0)
			System.out.println("None 			         -$0.0");
		System.out.printf("New Sub Total:                    $%.2f\n", subTotal);

		return subTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		double additionalDiscount = 0;
		if (newSubTotal > 150) {
			if (newSubTotal < 250) {
				additionalDiscount = newSubTotal * .10;
				System.out.printf("Additional 10%% Discount: 	 -$%.2f\n", additionalDiscount);
			} else if (newSubTotal > 250) {
				additionalDiscount = newSubTotal * 0.25;
				System.out.printf("Additional 25%% Discount:         -$%.2f\n", additionalDiscount);
			}

		} else
			System.out.printf("Additional 0%% Discount;          -$%.2f\n", additionalDiscount);
		System.out.printf("Final Total:			  $%.2f\n", (newSubTotal - additionalDiscount));

	}

	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = scnr.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts, MAXCHEESE);

		getAmount(scnr, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);

		if (MAXCHEESE != 0) {
			System.out.print("Display the itemized list? (1 for yes) ");
			int display = scnr.nextInt();

			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));

		printFinalTotal(newSubTotal);

		scnr.close();
	}
}