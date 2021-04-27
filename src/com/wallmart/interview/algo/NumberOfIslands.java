package com.wallmart.interview.algo;

/*
 * Given a grid of '1' and '0' find the number of islands.
 * '0' is water and '1' is land
 */
public class NumberOfIslands {

	public int getNumberOfIslands(char[][] grid) {
		int islands = 0;

		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					islands++;
					dfs(grid, i, j);
				}
			}
		}

		return islands;
	}

	private void dfs(char grid[][], int row, int col) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
			return;
		}

		grid[row][col] = '0';

		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}

	public static void main(String[] args) {

		char grid[][] = { { '1', '1', '1' }, { '0', '0', '0' }, { '1', '0', '1' } };

		NumberOfIslands numIs = new NumberOfIslands();

		System.out.println(numIs.getNumberOfIslands(grid));
	}
}
