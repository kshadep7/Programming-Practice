public class DigitPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12321));
    }

    static boolean isPalindrome(int num) {
        int div = (int) Math.pow(10, (int) Math.log10(num));

        while (num != 0) {

            int lead = num / div;
            int trail = num % 10;

            if (lead != trail)
                return false;

            num = (num % div) / 10;
            div = div / 100;
        }
        return true;
    }
}
