
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
			// scanner to read the user input
			Scanner scnr = new Scanner(System.in);
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

			int NumCheese = 0;
			System.out.print("Enter the number of Cheeses for shop setup:");
			NumCheese = scnr.nextInt();
			System.out.println();
			
		
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
			 
			double [] NameQtyArray = new double [NumCheese];
			double [] Xpacket = new double [NumCheese];
					for (int g1 = 3; g1 < NumCheese; g1++) {
						System.out.print("Enter the amount of Type " + (char) ('A' + g1) + " in lbs: ");
						NameQtyArray[g1] = (double) scnr.nextDouble();
						prices[g1] = ranGen.nextInt(1000) / 100.0;
						amounts[g1] = 0;
						 
						while (NameQtyArray[g1] < 0 || NameQtyArray[g1] % 0.5 != 0) {
							if (NameQtyArray[g1] <= 0) {
								System.out.print("Invalid input. Enter a value >=0: ");
							} else {
								System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
							}
							NameQtyArray[g1] = scnr.nextDouble();
					}
						int NamePacket = (int)(NameQtyArray[g1]/0.5);
						Xpacket [g1] = NamePacket;
					}
					
					System.out.println();
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
			if (choice == 1) 
				// print the details
				if (humboldtFogQty > 0)
					System.out.println((humboldtFogTotalPacket / 2) + " of Humboldt Fog @ $" + HumboldtPrice + " = $"
							+ (humboldtFogTotalPacket * (HumboldtPrice / 2)));
				if (redHawkQty > 0)
					System.out.println((redHawkTotalPacket / 2) + " of Red Hawk @ $" + RedHawkPrice + " = $"
							+ (redHawkTotalPacket * (RedHawkPrice / 2)));
				if (telemeQty > 0)
					System.out.println(telemeQty + " of Teleme @ $" + TelemePrice + " = $" + (telemePacket * (TelemePrice / 2)));
				
				for (int g1 = 3; g1 < NumCheese; g1++) {	
				if (NameQtyArray[g1] > 0)
					System.out.println(NameQtyArray[g1] + " of Type " + (char) ('A' + g1) + " @ $" + prices[g1] + " = $" + (Xpacket[g1] * (prices[g1]/ 2))); 
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
