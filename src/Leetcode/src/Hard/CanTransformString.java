package Hard;

public class CanTransformString {

    public static void main(String[] args) {
        String s = "abcdefgh", t = "bcdefghi";
        System.out.println(isHomomorphicII(s, t));
    }

    static boolean isHomomorphicII(String s, String t) {
        int length = s.length();
        if (length != t.length()) return false;

        int[] mapping = new int[26];
        boolean[] visited = new boolean[26];
        int uniq_count = 0;
        for (int i = 0; i < 26; i++) {
            mapping[i] = -1;
            visited[i] = false;
        }

        // build mapping
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i) - 'a';
            int tc = t.charAt(i) - 'a';
            if (mapping[sc] == -1) {
                mapping[sc] = tc;
            } else if (mapping[sc] != tc) {
                // this character maps to more than one character,
                // so it is not homomorphic
                return false;
            }
            // track how many unique characters appear in 't'
            if (!visited[tc]) {
                visited[tc] = true;
                uniq_count++;
            }
        }

        System.out.println(uniq_count);
        // if we have at least one swap character available then we can always transform the strings
        if (uniq_count < 26) return true;

        // at this point we don't have any characters available for swap space
        // so if even a single circular dependency exists then the strings
        // cannot be converted from one to the other using the global replaceAll

        for (int i = 0; i < 26; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < length; i++) {
            int sc = s.charAt(i) - 'a';
            if (!visited[sc]) {
                visited[sc] = true;
                // use fast and slow pointers
                int slow = sc, fast = sc;
                while (true) {
                    slow = mapping[slow];
                    if ((fast = mapping[fast]) == -1) break;
                    visited[fast] = true;
                    if ((fast = mapping[fast]) == -1) break;
                    visited[fast] = true;
                    // if fast == slow then a cycle was detected, and there aren't any swap characters available so fail
                    if (fast == slow) return false;
                }
            }
        }

        // if we made it this far, they are homomorphic and s can be transformed to t
        return true;
    }

}
