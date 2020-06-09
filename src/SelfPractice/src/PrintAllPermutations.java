import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

    static List<String> out = new ArrayList<>();

    public static void main(String[] args) {

        String str = "123456";
//        System.out.println(printAll(str));
        printPermutn(str, "", out);
        System.out.println(out);

    }

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans, List<String> out) {

        // If string is empty
        if (str.length() == 0) {
//            System.out.print(ans + " ");
            if (!out.contains(ans)) // for non duplicate items
                out.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding

            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch, out);
        }
    }

}
