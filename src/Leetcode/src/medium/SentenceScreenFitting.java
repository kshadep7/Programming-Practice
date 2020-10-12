package medium;

public class SentenceScreenFitting {

    public static void main(String[] args) {

        String[] s = {"hello", "world"};
        String[] s1 = {"a", "bcd", "e"};
        String[] s2 = {"I", "had", "apple", "pie"};

        System.out.println(count(s, 4, 8));
        System.out.println(count(s1, 3, 6));
        System.out.println(count(s2, 4, 5));
    }

    static int count(String[] sentence, int rows, int cols) {
        int i = 0;
        int res = 0;
        int k = 0;
        int colLen = cols;
        while (i < rows) {
            String word = sentence[k++];
            // base case
            if (word.length() > cols)
                return 0;
            // check if word can fit in current row
            if (word.length() <= colLen) {
                colLen = (colLen - word.length()) - 1;    // subtract len of word from col len and for space
            } else {        // else go to new line/row
                i++;
                colLen = cols;
                colLen = (colLen - word.length()) - 1;
            }
            // if rows are finished
            if (i >= rows)
                return res;
            // if sentence array is used up use it again by updating the k index
            // and also update res.
            if (k == sentence.length) {
                res++;
                k = 0;
            }
        }
        return res;
    }
}
