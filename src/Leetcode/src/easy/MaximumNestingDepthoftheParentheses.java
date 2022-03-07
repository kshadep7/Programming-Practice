package easy;

public class MaximumNestingDepthoftheParentheses {

	public static void main(String[] args) {
		String s = "(1+(2*3)+((8)/4))+1";
		System.out.println(sol(s));
	}

	public static int sol(String vps) {

		int res = 0;
		int curr = 0;
		for (int i = 0; i < vps.length(); i++) {
			if (vps.charAt(i) == '(')
				res = Math.max(res, ++curr);
			else if (vps.charAt(i) == ')')
				curr--;
		}
		return res;
	}
}
