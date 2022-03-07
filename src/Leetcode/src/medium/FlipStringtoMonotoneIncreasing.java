package medium;

public class FlipStringtoMonotoneIncreasing {

	public static void main(String[] args) {

		String s = "00110";
		String s1 = "010110";
		String s3 = "00011000";

		System.out.println(sol(s));
		System.out.println(sol(s1));
		System.out.println(sol(s3));
	}

	/*
	idea: understanding the monotone increasing term
	from left to right the char num should be increasing
	given binary string
	000111 is mono inc -> all ones are on right side
	00100 is not mono inc

			chars -> 0 1 2 3 4 5
	so, in eg str -> 0 1 0 1 1 0
	1. lets start with char 0 to 5
		0 -> sub str is still mono inc
		0 1 -> mono
		0 1 0 -> not mono - so to make it mono either make 1 -> 0 (flip = 1) or both 0s -> 1(flip = 2)
			take min of those flips i.e currflips = min(1,2) = 1
			and keeping a track of 1s will also let us know how many 1s we have seen so far
			to make them zero
		0 1 0 1 -> so 2 1s so far and before sub str only 1 flip was required which is last 0 -> 1
					so either make all 1s so far 0 or we can still use previous flip only
					which makes sense as in pre flip only 1 flip was done which was 0 -> 1
					which makes this sub str 0 1 1* 1 -> mono
		so on.....

		Algo:
		1. for 0 -> len of str
			1. track 1s -> char is 1
				then one++;
				else
					flip++;
				flip = min(one, flip);
		2. return flip

		TC: N
		SC: 1


	 */

	public static int sol(String s) {
		int one = 0;
		int flip = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				one++;
			else
				flip++;
			flip = Math.min(one, flip);
		}
		return flip;
	}
}
