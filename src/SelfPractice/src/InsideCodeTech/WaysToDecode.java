package InsideCodeTech;

public class WaysToDecode {

    public static void main(String[] args) {
        String str = "6324120129";
        System.out.println(waysToDecode(str, 0));
        System.out.println(waysToDecodeDP(str));
    }

    // TC: 2^n
    static int waysToDecode(String str, int index) {
        // if len = 0 then no way or 0 present inside str as single char then no way
        if (str.length() == 0 || (index < str.length() && str.charAt(index) == '0'))
            return 0;
        else if (index >= str.length() - 1) // str end reached so there is a way
            return 1;
        else {
            // checking if 2 chars can be used as to decode
            // if the num lies between 10 and 26
            int num = Integer.parseInt("" + str.charAt(index) + str.charAt(index + 1));
            if (10 <= num && num <= 26) {
                // take 1 char at a time
                return waysToDecode(str, index + 1)
                        + waysToDecode(str, index + 2); //plus 2 char
            } else
                // Just take 1 char
                return waysToDecode(str, index + 1);
        }
    }

    // to many repeatative calls
    // using DP
    // the idea is to check if char is 0 or not
    //if not then add previous char's value and check pre char and curr char fits in 10 and 26
    // if yes then also add before pre char's value
    // TC: n
    // SC: 1
    static int waysToDecodeDP(String str) {
        // base case
        if (str.length() == 0 || str.charAt(0) == '0')
            return 0;
        // instead of using an array using simple variables
        int beforePrevious = 1;     // first index of dp array
        int previous = 1;           // start of string
        for (int i = 1; i < str.length(); i++) {
            int current = 0;
            if (str.charAt(i) != '0')
                current += previous;

            int num = Integer.parseInt("" + str.charAt(i - 1) + str.charAt(i));
            if (10 <= num && num <= 26)
                current += beforePrevious;

            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
