import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter the number of cheeses for shop setup: ");
		int setup = scnr.nextInt();
		
		while (setup < 0) {
			System.out.print("Invalid input. Enter a value that's positive.");
			setup = scnr.nextInt();
		}

		System.out.println("We sell " + setup + " kinds of cheese (in 0.5 lb packages)");

		final int MAXCHEESE = setup;

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];
		double[] Oprice = new double[MAXCHEESE];
		double sub = 0;


		if (setup >= 0) {
			if (setup == 1) {
				names[0] = "Humboldt Fog";
				prices[0] = 25.00;

				System.out.println("Humbolt Fog: $25.0 per pound ");
			} else if (setup == 2) {
				names[0] = "Humboldt Fog";
				prices[0] = 25.00;

				names[1] = "Red Hawk";
				prices[1] = 40.50;

				System.out.println("Humbolt Fog: $25.0 per pound ");
				System.out.println("Red Hawk: $40.50 per pound ");
			} else if (setup > 2) {
				names[0] = "Humboldt Fog";
				prices[0] = 25.00;

				names[1] = "Red Hawk";
				prices[1] = 40.50;

				names[2] = "Teleme";
				prices[2] = 17.25;

				System.out.println("Humbolt Fog: $25.0 per pound ");
				System.out.println("Red Hawk: $40.50 per pound ");
				System.out.println("Teleme: $17.25 per pound ");

				Random ranGen = new Random(100);
				for (int i = 3; i < setup; i++) {
					names[i] = "Cheese Type " + (char) ('A' + i);
					prices[i] = ranGen.nextInt(1000) / 100.0;
					amounts[i] = 0;

					System.out.println(names[i] + ": $" + prices[i] + " per pound");
				}
			}

			System.out.println("");
			for (int i = 0; i < MAXCHEESE; i++) {

				System.out.print("Enter the amount of " + names[i] + " in lb: ");
				amounts[i] = scnr.nextDouble();

				while (amounts[i] % 0.5 != 0) {

					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[i] = scnr.nextDouble();

					if (amounts[i] < 0) {
						System.out.print("Invalid input. Enter a value >= 0:");
						amounts[i] = scnr.nextDouble();
					}
				}
				while (amounts[i] < 0) {
					System.out.print("Invalid input. Enter a value >= 0:");
					amounts[i] = scnr.nextDouble();

					if (amounts[i] % 0.5 != 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						amounts[i] = scnr.nextDouble();
					}
				}

				double OP = amounts[i] * prices[i];	
				Oprice[i] = OP;
			}

			if (setup != 0) {
				System.out.println("");
				System.out.print("Display the itemized list? (1 for yes): ");
				int display = scnr.nextInt();

				if (display == 1) {
					if (amounts[0] > 0)
						for (int i = 0; i < MAXCHEESE; i++) {
							if (amounts[i] > 0)
								System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i], prices[i],
										prices[i] * amounts[i]);
						}

					if (amounts[0] == 0)
						System.out.println("No items were purchased.");
				}
			}

			System.out.println("");
			for (int i = 0; i < MAXCHEESE; i++) {
				sub += Oprice[i];
			}
			System.out.printf("Original Sub Total:               $%.2f\n", sub);

		}

		double total = 0;
		for (int i = 0; i < amounts.length; i++) {
			total += amounts[i];
		}

		System.out.println("Specials...  ");
		if (setup == 0 || total == 0) {
			System.out.println("None 			         -$0.0");
			System.out.println("New Sub Total: 		          $0.00");
			System.out.println("Additional 0% Discount:          -$0.0");
			System.out.println("Final Total	    	          $0.00");
		}

		else if (setup > 0) {
			double hDiscount = 0;
			double rDiscount = 0;
			if (amounts[0] >= 1) {
				hDiscount = prices[0] * (int) (amounts[0]) / 2;
				System.out.println("Humbolt fog (Buy 1 Get 1 Free):   -$" + hDiscount);
			}
			if (setup > 1)
				if (amounts[1] >= 2) {
					double rDis = 0;
					for (int i = 0; i < amounts[1]; i++) {
						if (i % 2 == 0)
							rDis++;
					}
					rDiscount = rDis * 40.5 / 2;
					System.out.println("Red Hawk (Buy 2 Get 1 Free):      -$" + (rDiscount));
				}
			sub = 0;
			if (MAXCHEESE == 1) {
				sub = (Oprice[0] - hDiscount);
			} else if (MAXCHEESE == 2) {
				sub = ((Oprice[0] - hDiscount) + (Oprice[1] - rDiscount));
			} else if (MAXCHEESE > 2) {
				sub = ((Oprice[0] - hDiscount) + (Oprice[1] - rDiscount));
				for (int i = 2; i < MAXCHEESE; i++) {
					sub += Oprice[i];
				}
			}
			System.out.printf("New Sub Total:                     $%.2f\n", sub);

			double t = 0;

			if (sub > 150 && sub < 250) {
				t = (sub / 10);
				sub = sub - t;
				System.out.printf("Additional 10%% Discount: 	  -$%.2f\n", t);
			} else if (sub > 275) {
				t = (sub * 0.25);
				sub = sub - (sub * 0.25);
				System.out.printf("Additional 25%% Discount;          -$%.2f\n", t);
			} else if (sub > 250) {
				t = (sub * 0.15);
				sub = sub - (sub * 0.15);
				System.out.printf("Additional 15%% Discount;          -$%.2f\n", t);
			} else {
				System.out.printf("Additional 0%% Discount;           -$%.2f\n", t);
			}

			System.out.printf("Final Total:			   $%.2f\n", sub);
		}

	}

}
