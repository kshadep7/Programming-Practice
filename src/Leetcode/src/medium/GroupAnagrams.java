package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println((groupAnagrams(strs)));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		if(strs.length == 0 || strs== null) return new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for(String s : strs){

			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if(map.containsKey(key)){
				map.get(key).add(s);
			}else{
				map.put(key, new ArrayList<>());
				map.get(key).add(s);
			}
		}

		return new ArrayList(map.values());
	}
}
