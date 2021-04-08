package com.vmware.onlinetest;

import java.util.Arrays;
import java.util.List;

/*
 *  Given list of song durations, find the pairs of songs which sum up to 60 or multiples of 60
 *  
 *  songs = [10, 50, 90, 30]
 *  combinations are (10, 50) and (90, 30) so output is 2.
 */
public class SongCombinations {

	/*
	 * Time: O(n^2)
	 */
	public static Long playList(List<Integer> songs) {

		long songCount = 0;

		for (int i = 0; i < songs.size() - 1; i++) {

			for (int j = i + 1; j < songs.size(); j++) {

				if ((songs.get(i) + songs.get(j)) % 60 == 0) {
					songCount++;
				}
			}
		}

		return songCount;
	}

	/*
	 * Time complexity: O(N) 
	 * Auxiliary space: O(K) 
	 */
	public static Long playListCombinations(List<Integer> songs, int songDuration) {
		
		int freq[] = new int[songDuration];
		
		long songCount = 0;
		
		for (int i = 0; i < songs.size(); i++) {
			++freq[songs.get(i) % songDuration];
		}
		
		// if the song itself is of songDuration or its multiples
		songCount += freq[0] * (freq[0] - 1) / 2; // nCr  => n (n - 1) /2
		
		for (int i = 1; i <= songDuration/2 && i != songDuration - i; i++) {
			songCount += freq[i] * freq[songDuration - i];
		}
		
		// if the songDuration asked is even, then find the pairs of middle ones
		songCount += freq[songDuration / 2] * (freq[songDuration / 2] - 1) / 2;
		
		return songCount;
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> songs = Arrays.asList(new Integer[] {10, 50, 90, 30});
		
		System.out.println(playList(songs));
		
		System.out.println(playListCombinations(songs, 60));
	}
}
