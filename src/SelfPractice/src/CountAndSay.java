public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));

    }

    static String countAndSay(int n) {

        String s = "1";
        for (int i = 0; i < n-1; i++) {
            s = helper(s);
        }
        return s;
    }

    static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

}
