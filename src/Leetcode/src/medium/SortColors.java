package medium;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 6, 1, 9};
        sort(arr);
    }
//using sleep sort using thread
    static void sort(int[] arr) {

        for (final int i : arr) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(i * 500);
                        System.out.print(i + " ");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
