package Hard;

import java.util.ArrayList;

public class FancySequence {

    private ArrayList<Integer> list = new ArrayList<>();
    final int MAX = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public void append(int val) {
        list.add(val);
    }

    public void addAll(int inc) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < MAX / 10 || (list.get(i) >= MAX / 10 && inc <= MAX % 10)) {
                    int temp = list.get(i) + inc;
                    list.set(i, temp);
                }
            }
        }
    }

    public void multAll(int m) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < MAX / 100 || (list.get(i) >= MAX / 100 && m <= 100)) {
                    int temp = list.get(i) * m;
                    list.set(i, temp);
                }
            }
        }
    }

    public int getIndex(int idx) {
        if (!list.isEmpty() && idx < list.size())
            return list.get(idx);
        else
            return -1;
    }
}
