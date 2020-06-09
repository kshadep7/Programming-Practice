package medium;

public class DivideIntegers {

    public static void main(String[] args) {
//        System.out.println(divide(7, -3));
        System.out.println(Math.pow(-2, 30));
    }

    static int divide(int dend, int sor) {
        int sum = 0;
        int count = 0;

        try {
            while (sum < Math.abs(dend)) {
                sum += Math.abs(sor);
                count++;
            }
            if (dend < 0 || sor < 0)
                return -(count - 1);

            return count - 1;
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }

    }
}
