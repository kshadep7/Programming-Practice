package medium;

public class MutiplyStrings {

    public static void main(String[] args) {
        System.out.println(mul("123", "45"));
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    static String mul(String n1, String n2) {
        int[] arr = new int[n1.length() + n2.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = n1.length() - 1; i >= 0; i--) {
            for (int j = n2.length() - 1; j >= 0; j--) {
                int mul = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = mul + arr[p2];

                arr[p1] += sum / 10;
                arr[p2] = sum % 10;
            }

        }
        for (int i : arr) {
            if (sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
