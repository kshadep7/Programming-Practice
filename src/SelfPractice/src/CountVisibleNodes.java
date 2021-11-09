public class CountVisibleNodes {

	public static void main(String[] args) {
//		System.out.println(countPairs(new int[]{1, 212, 12, 12}, 1212));
//		System.out.println(countPairs(new int[]{777, 7, 777, 77, 77}, 7777));

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(9);

		System.out.println(countVisibleNodes(root));
	}

	static int countVisibleNodes(TreeNode root) {
		int[] res = new int[1];
		helper(root, Integer.MIN_VALUE, res);
		return res[0];
	}

	private static void helper(TreeNode root, int max, int[] res) {
		if (root != null) {
			max = Math.max(root.val, max);
			if (root.val >= max) {
				res[0]++;
				System.out.println(root.val);
			}
			helper(root.left, max, res);
			helper(root.right, max, res);
		}
	}

	// codesignal
	static int countPairs(int[] arr, int x) {

		int count = 0;
		String target = Integer.toString(x);
		for (int i = 0; i < arr.length; i++) {
			String first = Integer.toString(arr[i]);
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					String sec = Integer.toString(arr[j]);
					if (target.equals(first + sec))
						count++;
				}
			}
		}
		return count;
	}
}
