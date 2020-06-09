package LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {

    public static void main(String[] args) {

    }

    public void removeDuplicate(LinkedList<String> list) {
        // Add node.data to HashSet
        // if duplicate is found, simply do previous.next -> node.next
        // O(length of LinkedList) time complexity and Space is same as TC

        // OR
        // Using HashSet and java.util.LinkList
        // Just add all the elements of the LinkedList to HashSet
        // and return the
        HashSet<String> set = new HashSet<>();
        if (list.isEmpty()) {
            System.out.println("Empty list");
        } else {
            for (String s : list) {
                set.add(s);
            }
        }
        list.removeAll(list);
        list.addAll(set);
        System.out.println(list);
    }

}
