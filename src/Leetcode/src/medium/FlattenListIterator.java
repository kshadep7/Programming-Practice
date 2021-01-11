package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenListIterator {

    public static void main(String[] args) {
        ArrayList nestedList = new ArrayList();
        nestedList.add(Arrays.asList(9, 3, 4));
        nestedList.add(7);
        nestedList.add(Arrays.asList(Arrays.asList(2, 6), 4, Arrays.asList(Arrays.asList(1))));
        nestedList.add(Arrays.asList(Arrays.asList(Arrays.asList()), Arrays.asList(7), 6,
                Arrays.asList(5, Arrays.asList(), 0)));
        nestedList.add(2);
        nestedList.add(Arrays.asList(Arrays.asList(1), 5, 9));

        System.out.println(nestedList);

        for (Object ob : nestedList)
            System.out.println(ob + "->" + ob.getClass());

        System.out.println(flattenList(nestedList));
    }

    // TODO : Solve it !!
    static List<Object> flattenList(ArrayList nestedList) {
        ArrayList<Object> res = new ArrayList<>();
        helper(nestedList, res);

        return res;
    }

    private static void helper(ArrayList nestedList, List<Object> res) {

        for (Object ob : nestedList) {
            if (ob instanceof ArrayList) {
                helper((ArrayList) ob, res);
            } else {
                res.add(ob);
            }
        }
    }
}
