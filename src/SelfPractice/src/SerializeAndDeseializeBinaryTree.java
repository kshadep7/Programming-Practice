import java.util.*;

public class SerializeAndDeseializeBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(9);

//		System.out.println(serialize(root));
//		System.out.println(deserialize(serialize(root)).val);
//		System.out.println(Arrays.toString(solution(new String[]{"cat", "dog", "ferret", "scopion"})));
		System.out.println(Arrays.toString(sol(new int[]{3, 5, 1, 2}, new int[][]{{2}, {0, 2}, {1, 2}, {2}})));

	}


	static int[] sol(int[] nums, int[][] operations) {

		List<Integer> ls = new ArrayList<>();
		for (int i : nums)
			ls.add(i);
		Collections.sort(ls);
		List<Integer> res = new ArrayList<>();
		int min = ls.get(0);
		for (int[] op : operations) {
			if (op.length == 1) {
				// find min and add to res
				res.add(min);
			} else {
				if (op[0] == 1) {
					//append
					ls.add(op[1]);
					Collections.sort(ls);
					min = ls.get(0);
				} else if (op[0] == 0) {
					//add value to all i's
					for (int i = 0; i < ls.size(); i++) {
						ls.set(i, ls.get(i) + op[1]);
					}
				}
			}
		}

		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}


	static String[] solution(String[] arr) {

		List<String> res = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			String curr = arr[i];
			String next = "";
			if (i == arr.length - 1)
				next = arr[0];
			else
				next = arr[i + 1];
			res.add("" + curr.charAt(0) + next.charAt(next.length() - 1));
		}
		String[] ans = new String[res.size()];

		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}


	static String serialize(TreeNode root) {
		StringJoiner sj = new StringJoiner(" ");
		serializeHelperDFS(root, sj);
//		System.out.println(sj.toString());
		return sj.toString();
	}

	private static void serializeHelperDFS(TreeNode root, StringJoiner sj) {
		if (root == null) {
			sj.add("x");
			return;
		}
		sj.add(Integer.toString(root.val));
		serializeHelperDFS(root.left, sj);
		serializeHelperDFS(root.right, sj);
	}

	static TreeNode deserialize(String str) {
		String[] arr = str.split(" ");
		return deserializeHelperDFS(arr, 0);
	}

	private static TreeNode deserializeHelperDFS(String[] arr, int i) {
		if (arr[i].equals("x")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
		node.left = deserializeHelperDFS(arr, i + 1);
		node.right = deserializeHelperDFS(arr, i + 1);
		return node;
	}
}
