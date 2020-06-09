package ArraysAndStrings;

public class OneAway {

    public static void main(String[] args) {

    }

    public static boolean oneAway(String s1, String s2) {
        if (s1.equals(s2))
            return false;
        // length checks
        if (s1.length() - s2.length() > 1)
            return false;

        // get small and big strings
        String small = s1.length() < s2.length() ? s1 : s2;
        String big = s1.length() < s2.length() ? s2 : s1;
        int index1 = 0, index2 = 0;
        boolean diff = false;
        while (index2 < big.length() && index1 < small.length()) {
            if (small.charAt(index1) != big.charAt(index2)) {
                if (diff) // checking for first diff
                    return false;
                diff = true;
                if (small.length() == big.length()) // char replaced check
                    index1++;
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

}
