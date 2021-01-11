public class StringSpliting {

    public static void main(String[] args) {

        String s = "xzxzx";
        String s1 = "xzy";
        System.out.println(noOfWaysToSplitString(s1));
    }

    //Given a string S, Count number of ways of splitting S
    // into 3 non-empty a,b,c such that a+b, b+c, c+a are all different.
    static int noOfWaysToSplitString(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {      // N
            for (int j = i + 1; j < s.length(); j++) {  // N

                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);
                if (a.isEmpty() || b.isEmpty() || c.isEmpty())
                    continue;
                if (!((a + b).equals(b + c) || (b + c).equals(c + a) || (a + b).equals(c + a)))// N
                    count++;
            }
        }
        return count;
    }
}
