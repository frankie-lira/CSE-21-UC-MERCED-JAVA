
public class Preferences {

	int QuietTime = 0;
	int Music = 0;
	int Reading = 0;
	int Chatting = 0;
	
	public Preferences (int QuietTime, int Music, int Reading, int Chatting) {
		if (QuietTime >= 0 && QuietTime <= 10) {
			this.QuietTime = QuietTime;
		}
		
		if (Music >= 0 && Music <= 10) {
			this.Music = Music;
		}
		
		if (Reading >=0 && Reading <= 10) {
			this.Reading = Reading;
		}
		
		if (Chatting >= 0 && Chatting <= 10) {
			this.Chatting = Chatting;
		}
	}
	
	// These are the Accessors
	public int getQuietTime () {
		return QuietTime;
	}
	public int getMusic() {
		return Music;
	}
	public int getReading() {
		return Reading;
	}
	public int getChatting() {
		return Chatting;
	}
	
	
	public int compare(Preferences pref) {
		return (Math.abs(QuietTime - pref.QuietTime) + Math.abs(Music - pref.Music) + Math. abs(Reading - pref.Reading) + Math.abs(Chatting - pref.Chatting));
	}
}












