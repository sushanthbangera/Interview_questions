package com.onlinetest.zycus;

public class SubstringSearch {

	public static int find_string(String infStr, String toFind) {

		int result = 0;
		
		if (validFindInput(infStr, toFind)) {

			int index = infStr.indexOf(toFind.charAt(0));
			
			int lengthReq = toFind.length() * (index + 1);
			
			while (infStr.length() < lengthReq) {

				if (infStr.length() >= toFind.length()) {
					if (infStr.contains(toFind)) {
						result = 1;
						break;
					}
				} 
				infStr += infStr;
				
			}

		}

		return result;
	}

	public static boolean validFindInput2(String infStr, String toFind) {
		for (int i = 0; i < toFind.length(); i++) {
			if (infStr.indexOf(toFind.charAt(i)) > -1) {
				continue;
			}
			return false;
		}
		return true;
	}

	public static boolean validFindInput(String infStr, String toFind) {
		for (int i = 0; i < toFind.length(); i++) {
			if (!(infStr.indexOf(toFind.charAt(i)) > -1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String a = "abcdf";

		String f = "abce";

		String c = "cdfab";

		System.out.println(find_string(a, f));

		System.out.println(find_string(a, c));
	}
}
