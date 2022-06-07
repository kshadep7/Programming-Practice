package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PairsOfSongsWithTotalDuration60 {
	public static void main(String[] args) {

		int[] time = {30, 20, 150, 100, 40};
		System.out.println(numPairsDivisibleBy60(time));
	}

	public static int numPairsDivisibleBy60(int[] time) {
		int res = 0;
		for (int i = 0; i < time.length - 1; i++) {
			int first = time[i];
			for (int j = i + 1; j < time.length; j++) {
				int second = time[j];
				if ((first + second) % 60 == 0) {
					System.out.println(first + " " + second);
					res++;
				}
			}
		}

		return res;
	}

	//using hashmap
	// TC: N
	// SC: 1 -> fixed size map - max len 60
	public static int numPairsDivisibleBy601(int[] time) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < time.length; i++) {
			int key = time[i] % 60;
			int pairdKey = key == 0 ? key : 60 - key;

			res += map.getOrDefault(pairdKey, 0);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		return res;
	}

}