package com.interview.goldmansachs;

public class NumberOfSquares {

	/*
	 * Time: O(m x n)
	 */
	public int countSquares(int grid[][]) {
		int squareCount = 0;

		int row = grid.length;

		int col = grid[0].length;

		for (int i = 1; i < row; i++) {

			for (int j = 1; j < col; j++) {

				if (grid[i][j] == 0) {
					continue;
				}

				grid[i][j] = Math.min((Math.min(grid[i - 1][j], grid[i][j - 1])), grid[i - 1][j - 1]) + 1;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				squareCount += grid[i][j];
			}
		}
		return squareCount;
	}

	public static void main(String[] args) {

		int grid[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };

		NumberOfSquares nS = new NumberOfSquares();

		System.out.println(nS.countSquares(grid));
	}
}
