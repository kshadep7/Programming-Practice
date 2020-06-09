package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(emails));
    }

    static public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            String[] split = email.split("@", 2);
            String newStr = split[0];
            newStr = process(newStr);
            sb.append(newStr);
            sb.append("@");
            sb.append(split[1]);
            set.add(sb.toString());
            sb.setLength(0);
        }
        System.out.println(set);
        return set.size();
    }

    static String process(String str) {
        int index = str.indexOf('+');
        if (index != -1)
            str = str.substring(0, index);
        str = str.replaceAll("\\.", "");

        return str;
    }


}
