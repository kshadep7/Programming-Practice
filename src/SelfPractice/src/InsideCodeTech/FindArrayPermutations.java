package InsideCodeTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindArrayPermutations {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
    }

    // TODO: Solve it!!!
    static List<List<Integer>> findPerms(
            List<Integer> arr,
            List<Integer> currPerm,
            List<List<Integer>> res) {

        if (arr.size() < 2) {
            res.add(arr);
            return res;
        }
        currPerm = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> copyArr = new ArrayList<>(arr);
            int removedElement = copyArr.get(i);
            copyArr.remove(i);
            List<List<Integer>> remainingArr = findPerms(copyArr, currPerm, res);
            currPerm.add(removedElement);
        }
        return null;
    }
}
