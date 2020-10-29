public class Student {

	String Name;
	char Gender;
	Boolean Matched = false;
	Date Birthday;
	Preferences Pref;
	int CompatibilityScore;
	
	public Student (String Name, char Gender, Date Birthday, Preferences Pref) {
		this.Name = Name;
		this.Gender = Gender;
		this.Birthday = Birthday;
		this.Pref = Pref;
	}
	
	public void setMatched(boolean Matched) {
		this.Matched = Matched;
	}
	
	public String getName() {
		return Name;
	} 
	public char getGender() {
		return Gender;
	}
	public Boolean getMatched() {
		return Matched;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public Preferences getPreference() {
		return Pref;
	}
	
	public int compare (Student st) {
		if (Gender != st.Gender) {
			return 0;
		}
		
		CompatibilityScore = (40 - Pref.compare(st.Pref)) + (60 - Birthday.compare(st.Birthday));
		
		if (CompatibilityScore < 0) {
			return 0; 
		}
		else if (CompatibilityScore > 100) {
			return 100;
		}
		
		return CompatibilityScore;
		
	}

}


