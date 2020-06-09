import java.util.HashMap;
import java.util.Map;

public class RansomeNoteProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String note = "fgh";
		String mag = "dfghj";
		
//		boolean result = canConstruct1(note, mag);
		 System.out.println('b'-'a');

	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			String str = Character.toString(magazine.charAt(i));
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			String ranStr = Character.toString(ransomNote.charAt(i));
			if (map.containsKey(ranStr)) {
				map.put(ranStr, map.get(ranStr) - 1);
				if (map.get(ranStr) == -1) {
					return false;
				}

			} else {
				return false;
			}
		}
		return true;
	}

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
