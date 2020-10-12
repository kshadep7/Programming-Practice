public class ReduceNumber {

    public static void main(String[] args) {
        String num = "11111222333";
        System.out.println(reduceNum(num, 3));
    }

    /*
    *   111 112 223 33
    * */
    static String reduceNum(String number, int k) {

        while (number.length() > k) {
            String newNumber = "";
            // group k digits
            for (int i = 0; i < number.length() - k; i += k) {
                int t = 0;
                // convert k digits to int and add them
                for (int j = i; j < i + k; j++) {
                    if (j > number.length()) break;
                    t += Integer.parseInt("" + number.charAt(j));
                }
                newNumber += t;
            }
            number = newNumber;
        }
        return number;
    }
}
