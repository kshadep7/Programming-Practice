package medium;

import java.util.*;

public class InsertDeleteGetRandom {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand = new Random();

    public static void main(String[] args) {

        InsertDeleteGetRandom ins = new InsertDeleteGetRandom();
        for (int i = 0; i < 4; i++) {
            ins.insert(i);
        }
        System.out.println(ins.list);
        System.out.println(ins.map);
//        System.out.println(ins.getRandom());

        ins.delete(2);
        System.out.println(ins.list);
        System.out.println(ins.map);

    }

    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(list.size(), val);

        return true;
    }

    boolean delete(int val) {
        // idea is to copy the val with last value in the list
        // and then delete the last item
        if (!map.containsKey(val))
            return false;

        //get last element and copy it at the val index;
        int last = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
