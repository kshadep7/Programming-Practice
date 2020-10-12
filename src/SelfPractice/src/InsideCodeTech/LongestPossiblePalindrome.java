package InsideCodeTech;

public class LongestPossiblePalindrome {

    /*
     * Given a string str made of alphabetical letters only, create a function that returns
     * the length of the longest palindrome string that can be "MADE" from letters of str
     * */
    public static void main(String[] args) {

        String s = "abdccdceeebebc";
        System.out.println(longestLen(s));
    }

    static int longestLen(String s) {
        int len = 0;
        int[] count = new int[128];
        // count freq of chars
        for (char c : s.toCharArray()) {
            count[(int) c]++;
        }
        // if even then take all occurances and if odd take 1 less
        for (int i : count)
            len += i % 2 == 0 ? i : i - 1;

        // check for any letter left in the string if yes then add 1 coz
        // a letter can be added to plaindrome making it len of odd number
        // eg : abb e bba
        if (len < s.length())
            len++;
        return len;

    }
}
