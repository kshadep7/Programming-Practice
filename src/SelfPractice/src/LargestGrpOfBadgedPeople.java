import java.util.*;

public class LargestGrpOfBadgedPeople {

    /*
    We want to find employees who badged into our secured room together often.
    Given an unordered list of names and access times over a single day,
    find the largest group of people that were in the room together during two or more
    separate time periods, and the times when they were all present.*/
    public static void main(String[] args) {

        String[][] badge_records = {
                {"Paul", "1214", "enter"},
                {"Paul", "830", "enter"},
                {"Curtis", "1100", "enter"},
                {"Paul", "903", "exit"},
                {"John", "908", "exit"},
                {"Paul", "1235", "exit"},
                {"Jennifer", "900", "exit"},
                {"Curtis", "1330", "exit"},
                {"John", "815", "enter"},
                {"Jennifer", "1217", "enter"},
                {"Curtis", "745", "enter"},
                {"John", "1230", "enter"},
                {"Jennifer", "800", "enter"},
                {"John", "1235", "exit"},
                {"Curtis", "810", "exit"},
                {"Jennifer", "1240", "exit"}
        };
        /*
        Expected output:
        John, Paul, Jennifer: 830 to 900, 1230 to 1235
         */
//        group(badge_records);
        findLongestGroup(badge_records);

    }

    /*
[Curtis, 745, enter]
[Jennifer, 800, enter]
[Curtis, 810, exit]
[John, 815, enter]
[Paul, 830, enter]
[Jennifer, 900, exit]
[Paul, 903, exit]
[John, 908, exit]
[Curtis, 1100, enter]
[Paul, 1214, enter]
[Jennifer, 1217, enter]
[John, 1230, enter]
[Paul, 1235, exit]
[John, 1235, exit]
[Jennifer, 1240, exit]
[Curtis, 1330, exit]
*/

    static void findLongestGroup(String[][] records) {
        Arrays.sort(records, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

        // currState -> people in room currently
        Set<String> currState = new HashSet<>();
        // room state -> [start, end, currState]
        List<List> roomState = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            if (records[i][2].equals("enter")) {
                currState.add(records[i][0]);
            } else {
                String preTime = records[i - 1][1];
                roomState.add(Arrays.asList(preTime, records[i][1], new HashSet<>(currState)));
                currState.remove(records[i][0]);
            }
        }

        Set<String> largestGroup = new HashSet<>();
        List<List<String>> times = new ArrayList<>();

        for (int i = 0; i < roomState.size(); i++) {
            for (int j = i + 1; j < roomState.size(); j++) {
                String startTimeI = roomState.get(i).get(0).toString();
                String startTimeJ = roomState.get(j).get(0).toString();

                String endTimeI = roomState.get(i).get(1).toString();
                String endTimeJ = roomState.get(j).get(1).toString();

                Set<String> setI = (Set<String>) roomState.get(i).get(2);
                Set<String> setJ = (Set<String>) roomState.get(j).get(2);

                // get the largest group of people
                if ((Integer.parseInt(startTimeJ) > Integer.parseInt(endTimeI))) {
                    Set<String> common = new HashSet<>(setI);
                    common.retainAll(setJ);

                    if (common.size() > largestGroup.size()) {
                        largestGroup = common;
                    }
                }

            }
        }
        // get the times of the largest group
        // TODO: one time group is extra -> resolve it!!
        for (int i = 0; i < roomState.size(); i++) {
            Set<String> set = (Set<String>) roomState.get(i).get(2);
            if (largestGroup.size() <= set.size()) {
                String start = roomState.get(i).get(0).toString();
                String end = roomState.get(i).get(1).toString();
                if (!start.equals(end))
                    times.add(Arrays.asList(start, end));
            }
        }
        System.out.println(largestGroup.toString());
        System.out.println(times);
    }
}
