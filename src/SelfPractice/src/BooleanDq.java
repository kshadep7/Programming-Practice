import java.util.Arrays;

public class BooleanDq {

    public static void main(String[] args) {

        System.out.println(booleanDq(3, new String[]{"L", "L", "C1"}));
    }

    static String booleanDq(int n, String[] oprs) {

        char[] a = new char[n];
        Arrays.fill(a, '0');
        int minIndex = 0;

        for (String opr : oprs) {
            if (opr.equals("L")) {
                if (minIndex < n) {
                    a[minIndex] = '1';
                    while (minIndex < n && a[minIndex] == '1')
                        minIndex++;
                }
            } else {
                int ind = Integer.parseInt(opr.substring(1));
                if (ind < n) {
                    a[ind] = '0';
                    minIndex = Math.min(minIndex, ind);
                }
            }
            System.out.println("minIndex: " + minIndex);
        }
        return String.valueOf(a);
    }
}
