package com.wallmart.interview.algo;

/*
 * Given 2 dates as String find the number of days between them
 * 
 * Input "2020-07-12" and "2017-02-23"
 */
public class DateDiffFinder {

	private static final int[] monthDays = { 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getDateDifference(String date1, String date2) {
		int totalDaysDiff = 0;

		String[] date1Array = date1.split("-");
		String[] date2Array = date2.split("-");

		Date startDate = new Date(date1Array);
		Date endDate = new Date(date2Array);

		if (startDate.year > endDate.year) {
			Date temp = startDate;
			startDate = endDate;
			endDate = temp;
		}

		int yearDiff = startDate.year - endDate.year;
		int endYeardaysSpent = getSpentDays(endDate);

		if (yearDiff == 0) {
			int startYearDaysSpent = getSpentDays(startDate);
			totalDaysDiff = endYeardaysSpent - startYearDaysSpent;
		} else if (yearDiff == 1) {
			int startYearDaysRamaining = getRemainingDays(startDate);
			totalDaysDiff = startYearDaysRamaining + endYeardaysSpent;
		} else {
			int startYearDaysRamaining = getRemainingDays(startDate);
			int yearDays = getTotalYearDays(startDate.getYear() + 1, endDate.getYear());
			totalDaysDiff = startYearDaysRamaining + endYeardaysSpent + yearDays;
		}

		return totalDaysDiff;
	}

	private static int getSpentDays(Date date) {
		boolean isLeapYear = isLeapYear(date.getYear());
		// 31, 59, 90, 120, 151, 181, 201
		int totalDaysPassed = 0;

		for (int i = 0; i < date.getMonth() - 1; i++) {
			if (i != 1) {
				totalDaysPassed += monthDays[i];
			} else {
				totalDaysPassed += isLeapYear ? 29 : 28;
			}
		}
		totalDaysPassed += date.getDay();
		return totalDaysPassed;
	}

	private static int getRemainingDays(Date date) {
		int totalDaysPassed = getSpentDays(date);
		return isLeapYear(date.getYear()) ? (366 - totalDaysPassed) : (365 - totalDaysPassed);
	}

	private static int getTotalYearDays(int startYear, int endYear) {
		int totalYearDays = 0;

		for (int year = startYear; year < endYear; year++) {
			totalYearDays += isLeapYear(year) ? 366 : 365;
		}

		return totalYearDays;
	}

	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	static class Date {

		int day;

		int month;

		int year;

		public Date(String date[]) {
			this.year = Integer.parseInt(date[0]);
			this.month = Integer.parseInt(date[1]);
			this.day = Integer.parseInt(date[2]);
		}

		public int getDay() {
			return day;
		}

		public int getMonth() {
			return month;
		}

		public int getYear() {
			return year;
		}
	}
	
	public static void main(String[] args) {
		String date1 = "2017-08-20";
		String date2 = "2020-02-15";
		
		System.out.println(getDateDifference(date1, date2));
		
		date1 = "2017-08-20"; // 31, 28, 31, 30, 31, 30 31, 20
		date2 = "2017-02-15";
		
		System.out.println(getDateDifference(date1, date2));
	}
}
