package medium;

import java.util.*;

public class CourseScheduleII {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

		int num = 2;
		int[][] pre = {};

		int[][] pre1 = {{1, 0}, {0, 1}};

		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
//		System.out.println(Arrays.toString(findOrder(num, pre1)));
	}

	// simple topological sort approach
	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		List<Integer> res = new ArrayList<>();
		if (prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				res.add(i);
			}
		} else {
			Map<Integer, List<Integer>> graph = new HashMap<>();
			buildGraph(prerequisites, graph);
			Set<Integer> seen = new HashSet<>();
			for (int key : graph.keySet()) {
				if (!seen.contains(key)) {
					dfsHelper(graph, res, key, seen);
				}
			}
		}
		int[] arr = new int[res.size()];
		int i = 0;
		for (int x : res)
			arr[i++] = x;

		return arr;
//		return (int[]) res.toArray();
	}

	private static void buildGraph(int[][] prerequisites, Map<Integer, List<Integer>> graph) {
		for (int[] pre : prerequisites) {
			graph.putIfAbsent(pre[0], new ArrayList<>());
			graph.get(pre[0]).add(pre[1]);
		}

		System.out.println(graph);
	}

	private static void dfsHelper(Map<Integer, List<Integer>> graph, List<Integer> res, int key, Set<Integer> seen) {
		seen.add(key);
		List<Integer> preReqs = graph.get(key);
		if (preReqs != null) {
			for (int req : preReqs) {
				if (!seen.contains(req)) dfsHelper(graph, res, req, seen);
			}
		}
		res.add(key);
	}
}
