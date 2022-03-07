package medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

	public static void main(String[] args) {

		String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
		int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};

		// map ->
		// joe : (home, 1)(about, 2)(career, 3)
		// james: (home, 4)(cart, 5)(maps, 6)(home, 7)
		// mary : (home, 8)(about, 9)(career, 10)

		// so finding all patterns and counting freq of those
		// as the pattern will always have 3 webs so [n^3]

		System.out.println(mostVisitedPattern(username, timestamp, website));
	}

	static class Pair {
		String web;
		int time;

		public Pair(String web, int time) {
			this.web = web;
			this.time = time;
		}
	}

	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

		// getting users and their visited website with timestamp
		Map<String, List<Pair>> users = new HashMap<>();
		for (int i = 0; i < username.length; i++) {
			users.putIfAbsent(username[i], new ArrayList<>());
			users.get(username[i]).add(new Pair(website[i], timestamp[i]));
		}

//		System.out.println(users);
		// counting all patterns for each user
		Map<String, Integer> count = new HashMap<>();

		String res = ""; // for checking and storing our desired pattern
		for (String user : users.keySet()) {
			// set for making sure no duplicate patterns for each user
			Set<String> seen = new HashSet<>();
			List<Pair> list = users.get(user);
			// sort by time
			list.sort((a, b) -> a.time - b.time);
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					for (int k = j + 1; k < list.size(); k++) {
						String pattern = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
						if (!seen.contains(pattern)) {
							seen.add(pattern);
							count.put(pattern, count.getOrDefault(pattern, 0) + 1);
						}

						// checking for smaller lexographic pattern and updating res
						if (res == ""
								|| count.get(res) < count.get(pattern)
								|| (count.get(res) == count.get(pattern) && res.compareTo(pattern) > 0)) {

							res = pattern;
						}
					}
				}
			}
		}

		System.out.println(count);
		String[] s = res.split(" ");
		return new ArrayList<>(Arrays.asList(s));
	}
}
