package easy;

import java.util.Arrays;

public class VerifyingAlienDict {
    public static void main(String[] args) {
        String s = "hlabcdefgijkmnopqrstuvwxyz";
        String s2 = "worldabcefghijkmnpqstuvxyz";
        String s3 = "abcdefghijklmnopqrstuvwxyz";
        String[] arr = {"hello", "leetcode"};
        String[] arr2 = {"world", "word", "row"};
        String[] arr3 = {"apple", "app"};

        System.out.println(isSorted(arr2, s2));

    }

    static boolean isSorted(String[] words, String order) {
        int[] arr = new int[order.length()];

        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        System.out.println(Arrays.toString(arr));

        a:
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());
            b:
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (arr[word1.charAt(j) - 'a'] > arr[word2.charAt(j) - 'a'])
                        return false;

                    continue a;
                }
            }
            // if no difference found then the smaller word should be first followed by bigger word
            if (word1.length() > word2.length())
                return false;
        }
        return true;
    }
}
