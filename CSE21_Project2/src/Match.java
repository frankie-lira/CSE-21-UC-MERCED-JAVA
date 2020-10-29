import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
public class Match {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);

		Student[] arr = new Student[100];

		System.out.print("Please enter file name: ");
		String FileName = input.next();

		try {
			Scanner FileInput = new Scanner (new FileReader(FileName));
			int i = 0;

			while (FileInput.hasNextLine()){

				Scanner line = new Scanner(FileInput.nextLine());
				line.useDelimiter("[\t\r]"); //delimited
				String Name = line.next(); //(String)
				String Gender = line.next(); //(char)
				String Date = line.next(); //(String)

				Scanner BirthDateReader = new Scanner (Date);
				BirthDateReader.useDelimiter("-");
				int Month = BirthDateReader.nextInt();
				int Day = BirthDateReader.nextInt();
				int Year = BirthDateReader.nextInt();

				int quietTime = line.nextInt(); 
				int music = line.nextInt(); //int from 0-10
				int reading = line.nextInt(); //int from 0-10
				int chatting = line.nextInt(); //int from 0-10

				Date Birthdate = new Date (Month, Day, Year);
				Preferences Pref = new Preferences(quietTime, music, reading, chatting);
				Student StudentAdd = new Student(Name, Gender.charAt(0), Birthdate, Pref);
				arr[i++] = StudentAdd;

			}
			
			//the number of students get added in count above this code
			int Max = i; 
			for (i = 0; i < Max; i++){
				if (!arr[i].getMatched()){
					int BestScore = 0; int BestMatch = 0;
					for (int j = i + 1; j < Max; j++){
						if(!arr[j].getMatched()){
							int Tmp = arr[i].compare(arr[j]);
							if (Tmp > BestScore){
								BestScore = Tmp;
								BestMatch = j;


							}
						}
					}
					if (BestScore != 0){
						arr[i].setMatched(true);
						arr[BestMatch].setMatched(true);
						System.out.println(arr[i].getName() + " matches with " + arr[BestMatch].getName() + " with the score " + BestScore);
					} else
						if (!arr[i].getMatched())
							System.out.println(arr[i].getName() + " has no matches.");
				}
			}
			input.close();
		} catch (NoSuchElementException e){
			System.out.println(e);
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

}

