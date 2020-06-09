import java.util.*;

class Relations {
    String parent, child;

    public Relations(String parent, String child) {
        this.parent = parent;
        this.child = child;

    }
}

public class PrintTreeHierarchy {
    static Set<String> children = new HashSet<>();

    public static void main(String[] args) {
        List<Relations> list = new ArrayList<>();
        list.add(new Relations("animal", "mammal"));
        list.add(new Relations("animal", "bird"));
        list.add(new Relations("lifeform", "animal"));
        list.add(new Relations("cat", "lion"));
        list.add(new Relations("mammal", "cat"));
        list.add(new Relations("animal", "fish"));

        print(list);
    }

    public static void print(List<Relations> relList) {
        // building graph

        Map<String, Set<String>> graph = buildGraph(relList);

        // finding root of the from graph
        String root = findRoot(graph);
        // printing the tree hierarchy
        printTree(graph, 0, root);
    }

    private static void printTree(Map<String, Set<String>> graph, int level, String root) {
        
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(root);
        if (graph.containsKey(root)) {
            Set<String> set = graph.get(root);
            for (String key : set) {
                printTree(graph, level + 1, key);
            }
        }
    }

    private static String findRoot(Map<String, Set<String>> graph) {
        String root = "";
        for (String key : graph.keySet()) {
            if (!children.contains(key)) {
                root = key;
                break;
            }
        }

//        System.out.println(root);
        return root;
    }

    private static Map<String, Set<String>> buildGraph(List<Relations> relList) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (Relations rel : relList) {
            children.add(rel.child);
            if (!graph.containsKey(rel.parent))
                graph.put(rel.parent, new HashSet<>());
            graph.get(rel.parent).add(rel.child);
        }
        System.out.println(graph);
        return graph;
    }
}
