package medium;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValue {

	public static void main(String[] args) {

	}


}

class TimeMap {

	HashMap<String, TreeMap<Integer, String>> map;

	public TimeMap() {

		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new TreeMap<>());

		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> tmap;
		if (!map.isEmpty()) {
			tmap = map.get(key);
			if (tmap != null)
				return tmap.floorEntry(timestamp) == null ? "" : tmap.floorEntry(timestamp).getValue();
		}
		return "";
	}
}


