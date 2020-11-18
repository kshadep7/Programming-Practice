package InsideCodeTech;

import java.util.LinkedList;
import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(minTransactions(beginWord, endWord, wordList));
    }

    // using BFS
    static int minTransactions(String beginWord, String endWord, String[] wordList) {

        if (wordList == null || wordList.length == 0)
            return 0;

        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        int level = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String currStr = que.poll();
                assert currStr != null;
                char[] currArr = currStr.toCharArray();
                for (int j = 0; j < currArr.length; j++) {
                    char tempChar = currArr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        currArr[j] = k;
                        String newWord = String.valueOf(currArr);
                        if (endWord.equals(newWord))
                            return level + 1;
                        if (wordSet.contains(newWord)) {
                            que.offer(newWord);
                            wordSet.remove(newWord);
                        }
                        currArr[j] = tempChar;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
