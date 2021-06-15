public class FindMaxValue {

        public static void main(String[] args) {

                System.out.println(maxValue(268));
                System.out.println(maxValue(670));
                System.out.println(maxValue(0));
                System.out.println(maxValue(-999));

        }

        public static int maxValue(int N) {
                if (N >= 0) {
                        String num = Integer.toString(N);
                        for (int i = 0; i < num.length(); i++) {
                                if ('5' > num.charAt(i))
                                        return Integer.parseInt(num.substring(0, i) + "5" + num.substring(i));
                        }
                } else {
                        String num = Integer.toString(N);
                        for (int i = 1; i < num.length(); i++) {
                                if ('5' < num.charAt(i))
                                        return Integer.parseInt(num.substring(0, i) + "5" + num.substring(i));
                        }
                }

                return Integer.parseInt(N + "5");
        }
}
