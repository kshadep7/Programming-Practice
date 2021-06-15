package easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataLogFiles {

        public static void main(String[] args) {

//        Arrays.sort(new String[]{"fefef", "jdefe","zejfnef"});
                String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
//        System.out.println(Arrays.toString(reorder(logs)));
//        Arrays.sort(logs, (a, b) -> b.charAt(0) - a.charAt(0));
//        System.out.println(Arrays.toString(logs));
                System.out.println(Arrays.toString(arrange(logs)));
/*
// just fun :)
        int[] arr = {3, 1, 7, 3, 5, 9, 3};
        Arrays.sort(arr, 3, arr.length);
        System.out.println(Arrays.toString(arr));
*/
        }

        static String[] reorder(String[] logs) {
                Arrays.sort(logs, (log1, log2) -> {
                        String[] arr1 = log1.split(" ", 2);
                        String[] arr2 = log2.split(" ", 2);
                        boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
                        boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));
                        if (!isDigit1 && !isDigit2) {
                                int cmp = arr1[1].compareTo(arr2[1]);
                                if (cmp != 0)
                                        return cmp;
                                return arr1[0].compareTo(arr2[0]);
                        }
                        return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                });
                return logs;
        }

        static String[] arrange(String[] logs) {
                Comparator<String> myComp = new Comparator<>() {

                        @Override
                        public int compare(String log1, String log2) {
                                // splitting the logs into 2 parts (identifier, rest of log)
                                String[] arr1 = log1.split(" ", 2);
                                String[] arr2 = log2.split(" ", 2);
                                // check if both logs are letter-log or digit-log
                                boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
                                boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));
                                if (!isDigit1 && !isDigit2) {
                                        int cmp = arr1[1].compareTo(arr2[1]);
                                        if (cmp != 0)
                                                return cmp;

                                        return arr1[0].compareTo(arr2[0]);
                                }
                                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                        }
                };
                Arrays.sort(logs, myComp);
                return logs;
        }
}
