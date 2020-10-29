public class Date { 
	// Birthday

	int Year, Month, Day;

	public Date (int Month, int Day, int Year) {
		if (Month >= 1 && Month <= 12)
			this.Month = Month;

		if (Year >= 1900 && Year <= 3000)
			this.Year = Year;
		
		if (Day >= 1 && Day <= 31)
			this.Day = Day;
		
		
	}

	// These are the Accessors
	public int getMonth() {
		return Month;
	}

	public int getDay() {
		return Day;
	}
	
	public int getYear() {
		return Year;
	}

	public int dayOfYear() {
		int TotalDays = 0;

		switch (Month) {
		case 12: TotalDays += 30;
		case 11: TotalDays += 31;
		case 10: TotalDays += 30;
		case 9 : TotalDays += 31;
		case 8 : TotalDays += 31;
		case 7 : TotalDays += 30;
		case 6 : TotalDays += 31;
		case 5 : TotalDays += 30;
		case 4 : TotalDays += 31;
		case 3 : TotalDays += 28;
		case 2 : TotalDays += 31;
		}
		TotalDays += Day;
		return TotalDays;
	}
	public int compare(Date dt) {
		int yearsDifferenceInDays = Math.abs((Year - dt.Year) * 365);

		int daysDifference = dayOfYear() - dt.dayOfYear();

		int totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);

		int monthsDifference = totalDifference/30;

		if (monthsDifference > 60) 
			monthsDifference = 60;

		return monthsDifference;
	}

}

