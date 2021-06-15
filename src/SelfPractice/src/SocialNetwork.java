import java.net.Inet4Address;
import java.util.*;

public class SocialNetwork {

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
//        System.out.println(groupThePeople(new int[]{2, 2, 2, 2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> listMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (!listMap.containsKey(groupSize)) {
                listMap.put(groupSize, new ArrayList<>());
            }
            ArrayList<Integer> tempList = listMap.get(groupSize);
            tempList.add(i);
            if (tempList.size() == groupSize) {
                result.add(tempList);
                listMap.put(groupSize, new ArrayList<Integer>());
            }
        }
        System.out.println(listMap);
        Collections.sort(result, new Comparator<List<Integer>>() {

            public int compare(List<Integer> a1, List<Integer> a2) {
                if (a1.size() > a2.size()) {
                    return -1;
                } else if (a1.size() < a2.size()) {
                    return 1;
                }
                return 0;
            }
        });
        return result;
    }
}
