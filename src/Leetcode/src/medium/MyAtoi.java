package medium;

public class MyAtoi {

	public static void main(String[] args) {

		System.out.println(myAtoi("   +0 123"));
	}

	public static int myAtoi(String s) {
		if (s.isEmpty())
			return 0;
		String str = removeWS(s);
		System.out.println(str);
		if(str.isEmpty())
			return 0;
		int sign = 1, base = 0, i = 0;
		// while (str.charAt(i) == ' ')
		// i++;

		if (str.charAt(i) == '-' || str.charAt(i) == '+')
			sign = str.charAt(i++) == '-' ? -1 : 1;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = 10 * base + (str.charAt(i++) - '0');
		}
		return base * sign;
	}

	public static String removeWS(String s) {
		String str = "";
		for (char c : s.toCharArray()) {
			if (c == ' ')
				continue;

			str += Character.toString(c);
		}
		return str;
	}
}
