import java.util.Scanner;

public class CheeseShop {
	public static void main(String[] args) {
		// scanner to read the user input
		Scanner scnr = new Scanner(System.in);

		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humboldt Fog: $25.0 per pound");
		System.out.println("Red Hawk: $40.5 per pound");
		System.out.println("Teleme: $17.25 per pound");

		double HumboldtPrice = 25.0;
		double RedHawkPrice = 40.5;
		double TelemePrice = 17.25;

		System.out.println();

		// get the value of each type one by one and validation for each input
		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		double humboldtFogQty = scnr.nextDouble(); 

		while (humboldtFogQty < 0 || humboldtFogQty % 0.5 != 0) {
			if (humboldtFogQty <= 0) {
				System.out.print("Invalid input. Enter a value >=0: ");
			}

			else {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
			}
			humboldtFogQty = scnr.nextDouble();
		}

		// convert input lns to packets
		int humboldtFogPacket = (int) (humboldtFogQty / 0.5);

		System.out.print("Enter the amount of Red Hawk in lbs: ");
		double redHawkQty = scnr.nextDouble();

		while (redHawkQty < 0 || redHawkQty % 0.5 != 0) {
			if (redHawkQty <= 0) {
				System.out.print("Invalid input. Enter a value >=0: ");
			} else {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
			}
			redHawkQty = scnr.nextDouble();
		}

		// convert input lns to packets
		int redHawkPacket = (int) (redHawkQty / 0.5);

		System.out.print("Enter the amount of Teleme Fog in lbs: ");
		double telemeQty = scnr.nextDouble();
		System.out.print("\n");

		while (telemeQty < 0 || telemeQty % 0.5 != 0) {
			if (telemeQty <= 0) {
				System.out.print("Invalid input. Enter a value >=0: ");
			} else {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
			}
			telemeQty = scnr.nextDouble();
		}

		// convert input lns to packets
		int telemePacket = (int) (telemeQty / 0.5);

		// ask user if need to show itemized list
		System.out.print("Display the itemized list? (1 for yes) ");
		int choice = scnr.nextInt();//Integer.parseInt(scnr.nextLine());

		// calculate extra packet required.
		int humboldtFogExtraPacket = humboldtFogPacket;
		int redHawkExtraPacket = redHawkPacket / 2;

		// get the total packet count
		double humboldtFogTotalPacket = humboldtFogPacket + humboldtFogExtraPacket;
		double redHawkTotalPacket = redHawkPacket + redHawkExtraPacket;

		// Itemized list
		if (choice == 1) {
			// print the details
			if (humboldtFogQty > 0)
				System.out.println((humboldtFogTotalPacket / 2) + " of Humboldt Fog @ $" + HumboldtPrice + " = $"
						+ (humboldtFogTotalPacket * (HumboldtPrice / 2)));
			if (redHawkQty > 0)
				System.out.println((redHawkTotalPacket / 2) + " of Red Hawk @ $" + RedHawkPrice + " = $"
						+ (redHawkTotalPacket * (RedHawkPrice / 2)));
			if (telemeQty > 0)
				System.out.println(
						telemeQty + " of Teleme @ $" + TelemePrice + " = $" + (telemePacket * (TelemePrice / 2)));

		}

		// Subtotal 
		double subTotal = (humboldtFogTotalPacket * (HumboldtPrice / 2)) + (redHawkTotalPacket * (RedHawkPrice / 2))
				+ (telemePacket * (TelemePrice / 2));
		System.out.println("\n");
		System.out.println("Sub total:                        $" + subTotal);
		System.out.println("Discounts...");

		// print the discount details
		if ((humboldtFogQty == 0 && redHawkQty == 0)) 
			System.out.println("None                             " + "-$0.0");
		if (humboldtFogQty > 0)
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + (humboldtFogExtraPacket * (HumboldtPrice / 2)));
		if (redHawkQty >= 1)
			System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + (redHawkExtraPacket * (RedHawkPrice / 2)));

		// calculate total discount
		double discount = (humboldtFogExtraPacket * (HumboldtPrice / 2)) + (redHawkExtraPacket * (RedHawkPrice / 2));
		// print the total price
		System.out.println("Total:                            $" + (subTotal - discount));

	}

}
