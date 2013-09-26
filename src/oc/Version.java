package oc;

public class Version {

	/*********************************************************************/

	// CHANGE ON ANY UPDATE!

	private static int year = 2013;
	private static int month = 9;
	private static int day = 26;
	private static int hour = 17;
	private static int minute = 26;

	/*********************************************************************/

	private static Version instance;

	private Version() {
	}

	public static Version getInstance() {
		if(instance == null) {
			instance = new Version();
		}
		return instance;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}


}
