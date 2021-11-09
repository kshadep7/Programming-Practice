package medium;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        List<String> l1 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));
        List<String> l2 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        List<String> l3 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));
//        List<String> l = new ArrayList<>(Arrays.asList("1", "a", "b", "c"));
//        List<String> l1 = new ArrayList<>(Arrays.asList("1", "d"));
//        List<String> l2 = new ArrayList<>(Arrays.asList("1", "b", "e", "z"));
//        List<String> l3 = new ArrayList<>(Arrays.asList("2", "f", "g"));

        List<List<String>> acc = new ArrayList<>();
        Collections.addAll(acc, l, l2, l3, l1);

//        System.out.println(acc);
//        System.out.println("Merged accounts: ");
//        System.out.println(merge(acc));

        sol(10);
    }

    /*
     *   [   ["John", "johnsmith@mail.com", "john00@mail.com"],
     *       ["John", "johnnybravo@mail.com"],
     *       ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
     *       ["Mary", "mary@mail.com"]]

     * */
    static List<List<String>> merge(List<List<String>> accounts) {
        List<List<String>> out = new ArrayList<>();
        Map<String, String> parentMap = new HashMap<>();
        Map<String, String> ownerMap = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();

        // building parentMap and ownerMap
        for (List<String> lst : accounts) { //  N
            for (int i = 1; i < lst.size(); i++) { // M
                parentMap.put(lst.get(i), lst.get(i));
                ownerMap.put(lst.get(i), lst.get(0));
            }
        }
        // updating parentMap using find()
        for (List<String> lst : accounts) { // N
            String parent = find(lst.get(1), parentMap);
            for (int i = 2; i < lst.size(); i++) { // M
                parentMap.put(find(lst.get(i), parentMap), parent);
            }
        }

        // now building union map
        for (List<String> lst : accounts) { // N
            String parent = find(lst.get(1), parentMap);
            if (!union.containsKey(parent))
                union.put(parent, new TreeSet<>());
            for (int i = 1; i < lst.size(); i++) { //M
                union.get(parent).add(lst.get(i)); // adding in tree set -> M Log M
            }
        }

        // building output list with names at index 0
        for (String str : union.keySet()) {
            List<String> emails = new ArrayList<>(union.get(str));
            emails.add(0, ownerMap.get(str));
            out.add(emails);
        }

        return out;
    }

    static String find(String child, Map<String, String> parent) {
        return parent.get(child).equals(child) ? child : find(parent.get(child), parent);
    }


    public static void sol(Integer num) {
        if(num > 0) {
            System.out.print(num);
            sol(num -1);
        }
    }
}
