package com.nineleaps.onlinecoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner sc = new Scanner(System.in);
		String sub = sc.nextLine();

		int t = Integer.parseInt(sub);

		ArrayList<Account> list = new ArrayList<Account>();

		for (int i = 0; i < t; i++) {
			String[] input = sc.nextLine().split(" ");
			list.add(new Account(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
		}

		Collections.sort(list);

		System.out.println("Most valuable account details:");
		System.out.println(list.get(list.size() - 1));
	}
}