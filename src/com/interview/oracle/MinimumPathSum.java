package com.interview.oracle;

/*
 *  19 Nov 2020
 */
public class MinimumPathSum {

	public int getMinPathSum(int grid[][]) {

		int row = grid.length;

		int col = grid[0].length;

		int dp[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				}
			}
		}

		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {

		int grid[][] = { { 1, 9, 4 }, { 2, 3, 8 }, { 2, 4, 9 } };

		MinimumPathSum minSumPath = new MinimumPathSum();

		System.out.println(minSumPath.getMinPathSum(grid));
	}
}
