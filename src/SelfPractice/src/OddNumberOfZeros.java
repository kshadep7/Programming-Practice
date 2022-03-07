public class OddNumberOfZeros {

	public static void main(String[] args) {

		int[] a = {5, 10, 200, 10070, 56};
		int[] a1 = {4, 50, 100, 65, 2000, 700, 1, 10};

		System.out.println(numOddOccurrencesOfZero(a1));
		System.out.println(numOddOccurrencesOfZero(a));
	}

	static int numOddOccurrencesOfZero(int[] a) {
		int numOddZeros = 0;

		for (int i = 0; i < a.length; i++) {
			String intString = Integer.toString(a[i]);

			int numZeros = 0;
			for (int j = 0; j < intString.length(); j++) {
				if (intString.charAt(j) == '0')
					numZeros++;
			}

			if (numZeros % 2 == 1)
				numOddZeros++;
		}

		return numOddZeros;
	}
}
