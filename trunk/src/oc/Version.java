package oc;

public class Version {

	/*********************************************************************/

	// CHANGE ON ANY UPDATE!

	private static int year = 2014;
	private static int month = 01;
	private static int day = 03;
	private static int hour = 12;
	private static int minute = 00;

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
