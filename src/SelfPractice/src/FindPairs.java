// You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

// Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

// Sample Input:

// student_course_pairs_1 = [
//   ["58", "Linear Algebra"],
//   ["94", "Art History"],
//   ["94", "Operating Systems"],
//   ["17", "Software Design"],
//   ["58", "Mechanics"],
//   ["58", "Economics"],
//   ["17", "Linear Algebra"],
//   ["17", "Political Science"],
//   ["94", "Economics"],
//   ["25", "Economics"],
//   ["58", "Software Design"],
// ]

// map
// 58: LA, mech, econ, softdes
// 94 : ah, oprs, econ
// 17 : softd, la, polisc
//=========
// la : 58, 17
//softw : 17, 58

// Sample Output (pseudocode, in any order):

// find_pairs(student_course_pairs_1) =>
// {
//   "58,17": ["Software Design", "Linear Algebra"]
//   "58,94": ["Economics"]
//   "58,25": ["Economics"]
//   "94,25": ["Economics"]
//   "17,94": []
//   "17,25": []
// }


// Additional test cases:

// Sample Input:

// student_course_pairs_2 = [
//   ["42", "Software Design"],
//   ["0", "Advanced Mechanics"],
//   ["9", "Art History"],
// ]

// Sample output:

// find_pairs(student_course_pairs_2) =>
// {
//   "0,42": []
//   "0,9": []
//   "9,42": []
// }


/*
Map -> set(ids), set(courses)
*/

// n: number of pairs in the input
// s: number of students
// c: number of courses being offered

import java.util.*;

public class FindPairs {
    public static void main(String[] argv) {
        String[][] studentCoursePairs1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}

        };

        String[][] studentCoursePairs2 = {
                {"42", "Software Design"},
                {"0", "Advanced Mechanics"},
                {"9", "Art History"},
        };

        System.out.println(findPairs(studentCoursePairs1));
        System.out.println(findPairs(studentCoursePairs2));
    }

    static public Map<List<String>, Set<String>> findPairs(String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String[] pair : pairs) {
            String key = pair[0];
            String value = pair[1];
            if (map.containsKey(key)) {
                Set<String> set = map.get(key);
                set.add(value);
                map.put(key, set);
            } else {
                Set<String> newSet = new HashSet<>();
                newSet.add(value);
                map.put(key, newSet);
            }
        }
//     System.out.println(map);

        List<String> keys = new ArrayList<>();
        for (String key : map.keySet()) {
            keys.add(key);
        }

        Map<List<String>, Set<String>> res = new HashMap<>();
        for (int i = 0; i < keys.size() - 1; i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                Set<String> first = map.get(keys.get(i));
                Set<String> second = map.get(keys.get(j));
                Set<String> mutaualCourses = new HashSet<>(first);

                List<String> idPair = new ArrayList<>();
                idPair.add(keys.get(i));
                idPair.add(keys.get(j));
                mutaualCourses.retainAll(second);

                res.put(idPair, mutaualCourses);
            }
        }
//        System.out.println(res);
        return res;
    }
}

