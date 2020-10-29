import java.util.Scanner;
public class RemainderFunc {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int maxnum, divisor;

		System.out.print("Please enter the max number: ");
		maxnum = scnr.nextInt();

		while (maxnum < 0) {

			System.out.print("Invalid input. Please enter a valid max number (>=0): ");
			maxnum = scnr.nextInt();
		}

		System.out.print("Please enter the divisor: ");
		divisor = scnr.nextInt();
		
		while (divisor < 0) {
			System.out.print("Invalid input. Please enter a valid divisor (>=0): ");
			divisor = scnr.nextInt();
		}

		System.out.println("Multiples of " + divisor + " between 1 and " + maxnum + " (inclusive) are:");
		for (int i = 1; i <= maxnum; i++) {
			if (i % divisor == 0)
				System.out.println(i);
			
		}

	}

}