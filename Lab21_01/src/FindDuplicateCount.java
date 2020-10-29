
public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2 };
		
		for (int i = 0; i < arr.length; i++) {
			int c = 0; 
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr [j])
					c++;
			}
			
			if (c == 0)
				System.out.println("There are no duplicates with value " + arr[i] + " beyond index " + i);

			else if (c == 1)
				System.out.println("There is only " + c + " more occurances of value " + arr[i] + " starting index " + i);
			
			else
				System.out.println("There are " + c + " more occurances of value " + arr[i] + " starting index " + i);
		}
			

	}

}
