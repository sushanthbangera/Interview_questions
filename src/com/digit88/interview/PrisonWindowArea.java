package com.digit88.interview;

import java.util.List;

public class PrisonWindowArea {
	
	public static long prison(int n, int m, List<Integer> h, List<Integer> v) {

		boolean[] hArr = new boolean[n + 1];
		boolean[] vArr = new boolean[m + 1];

		for (int i : h) {
			hArr[i] = true;
		}

		for (int i : v) {
			vArr[i] = true;
		}

		int hMax = 0, vMax = 0;
		int diff = 0;

		for (int i = 1; i < n + 1; i++) {
			if (!hArr[i]) {
				diff = 0;
			} else {
				diff++;
				hMax = Math.max(hMax, diff);
			}
		}

		diff = 0;

		for (int i = 1; i < m + 1; i++) {
			if (!vArr[i]) {
				diff = 0;
			} else {
				diff++;
				vMax = Math.max(vMax, diff);
			}
		}

		return (long) (hMax + 1) * (vMax + 1);
	}
}
