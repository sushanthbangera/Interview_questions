package com.interview.nike;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 *  Give 2 data sets in a csv file, 1st
 * Data set contains the amount of fire occurred (some event) for different cities in a month
 * The second Data set contains the annual data of all cities
 * 
 * Verify if the given 2 data sets are matching
 */
public class CSVFileReader {

	public static void main(String[] args) throws IOException {
		// InputStreamReader reader = new InputStreamReader(new
		// File("/Users/icluster/Documents/Study/nike.csv"), StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(new FileReader("/Users/icluster/Documents/Study/nike.csv"));
		String line;

		Map<String, Integer> stateFireStats = new HashMap<>();

		boolean firstDataSetComplete = false;

		boolean result = true;

		while ((line = in.readLine()) != null) {

			// skip the empty line
			if (line.trim().equals("") || line.trim().equals("\n")) {
				firstDataSetComplete = true;
				continue;
			}

			String[] str = line.split(",");
			//skip the header
			if (str[0].equals("state") || str[0].equals("year")) {
				continue;
			}

			if (!firstDataSetComplete) {
				stateFireStats.put(str[0], (stateFireStats.getOrDefault(str[0], 0) + Integer.parseInt(str[3])));
			} else {
				int annualCount = Integer.parseInt(str[1]);
				if (stateFireStats.get(str[0]) != annualCount) {
					result = false;
					break;
				} // close inner if
			} // close else if

		} // close while

		System.out.println(result ? "Valid Data Sets" : "Invalid Data Set");
		in.close();
	}// close main

}
