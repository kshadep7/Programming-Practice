package easy;

import java.util.Arrays;

public class DefangIPAddr {

	public static void main(String[] args) {

		String address = "1.1.1.1";
		defangIPaddr(address);
	}

	public static void defangIPaddr(String address) {
// can be optimized by using StringBuilder.
		String[] str = address.split("\\.");
		System.out.println(Arrays.toString(str));
		String res = "";
		for (int i = 0; i < 3; i++) {
			res = res + str[i] + "[.]";
		}
		System.out.println(res+ str[str.length-1]);
		
	}

}
