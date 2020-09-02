public class MaxKOccurSequences {

    public static void main(String[] args) {

        String seq = "ababcbabc";
        String[] words = {"ab", "babc", "bca"};

        // res array should be -> [2,2,0]
        // Explanation:
        // ab -> abab -> twice in seq
        // babc -> babcbabc -> twice in seq
        // bca -> 0 times in seq
    }

    // TODO: solve it!!
    static int[] maxKOccurances(String seq, String[] words) {

        int[] res = new int[words.length];
        for (String word : words) {

        }
        return null;
    }
}
