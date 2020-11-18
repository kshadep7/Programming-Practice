package medium;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        String start = "hit";
        String end = "cog";
        List<String> dict = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(transforms(start, end, dict));
    }
/*
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5
*/

    static int transforms(String start, String end, List<String> dict) {
        Set<String> set = new HashSet<>(dict);

        if (!set.contains(end))
            return 0;

        Queue<String> que = new LinkedList<>();
        que.offer(start);
        int level = 1;

        while (!que.isEmpty()) {    // word list size m -> worst case
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) { // n
                String curr = que.poll();
//                System.out.println(curr);
                assert curr != null; // to remove warning of curr being null
                char[] currArr = curr.toCharArray();
                for (int j = 0; j < currArr.length; j++) {      // n
                    char currChar = currArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {     // 26
                        if (currArr[j] == c)
                            continue;
                        currArr[j] = c;
                        String newWord = String.valueOf(currArr);
                        if (newWord.equals(end)) {
                            return level + 1;
                        }
                        if (set.contains(newWord)) {
                            que.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    currArr[j] = currChar;
                }
            }
            level++;
        }
        return 0;
    }

}
