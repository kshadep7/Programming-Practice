import java.util.HashMap;
import java.util.Map;

public class DigitAnagram {

    public static void main(String[] args) {
        int[] a = {21, 12, 44, 43, 34};
        int[] b = {25, 35, 872, 228, 53, 278, 872};

        System.out.println(noOfDigitAnagrams(a));
    }

    // TC : n3
    static int noOfDigitAnagrams(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {          // N
            int lenA = (int) (Math.log10(arr[i]) + 1);
            String numA = "" + arr[i];
            Map<Character, Integer> mapA = new HashMap<>();
            countFreq(numA, mapA);
            a:
            for (int j = i + 1; j < arr.length; j++) {      //N
                int lenB = (int) Math.log10(arr[j]) + 1;
                if (lenA != lenB)
                    continue;
                String numB = "" + arr[j];
                Map<Character, Integer> mapB = new HashMap<>();
                countFreq(numB, mapB);
                for (char key : mapA.keySet()) {            //N
                    if (mapB.containsKey(key)) {
                        if (!mapB.get(key).equals(mapA.get(key)))
                            continue a;
                    } else continue a;
                }
                count++;
            }
        }
        return count;
    }

    private static void countFreq(String i, Map<Character, Integer> map) {
//        int len = (int) (Math.log10(Integer.parseInt(i)) + 1);
        for (char a : i.toCharArray()) {
            if (map.containsKey(a))
                map.put(a, map.get(a) + 1);
            else
                map.put(a, 1);
        }
//        System.out.println(map);
    }


}
