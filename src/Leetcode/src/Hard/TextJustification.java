package Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;

		String[] words1 = {"What","must","be","acknowledgment","shall","be"};
		int maxWidth1 = 16;


		for (String str : fullJustify(words, maxWidth))
			System.out.println(str);

		for (String str : fullJustify(words1, maxWidth1))
			System.out.println(str);
	}

	/*
	Idea:
	1. looping thru words
		1.1 first keep on adding word's length to linelength with spaces to check if
		its <= maxWidth
		1.2 if more than 1 word then middle justify
		1.3 if 1 word or last line (check j >= len(word)) then left justify

	TC: O(line of maxWidth * words)
	 */
	public static List<String> fullJustify(String[] words, int maxWidth) {

		List<String> result = new ArrayList<>();
		int i = 0, n = words.length;
		// 1
		while (i < n) {
			// j will always be next to i
			int j = i + 1;
			// 1.1
			int lineLength = words[i].length();
			// check if j < n and sum of words and spaces < max width
			while (j < n && (lineLength + words[j].length() + (j - i - 1)) < maxWidth) {
				lineLength += words[j].length();
				j++;
			}
			// 1.3
			// count no of words
			int noOfWords = j - i;
			// remaining char spaces
			int diff = maxWidth - lineLength;
			// one word or last line
			if (noOfWords == 1 || j >= n)
				result.add(leftJustify(words, diff, i, j));
			else
				result.add(middleJustify(words, diff, i, j));

			// update i for next iteration
			i = j;
		}
		return result;
	}

	private static String leftJustify(String[] words, int diff, int i, int j) {
		// diff - no of spaces required between words
		int spaceOnRight = diff - (j - i - 1);

		// using SB and first word already added
		StringBuilder res = new StringBuilder(words[i]);
		for (int k = i + 1; k < j; k++) {
			// append single spaces and next word
			res.append(" " + words[k]);
		}

		// append rem spaces i.e spaces on right
		for (int k = 0; k < spaceOnRight; k++) {
			res.append(" ");
		}

		return res.toString();
	}

	private static String middleJustify(String[] words, int diff, int i, int j) {
		// no of spaces between words -> no of words - 1
		int spaceNeeded = j - i - 1;
		// least spaces needed to evenly space between words
		int leastSpaceNeed = diff / spaceNeeded;
		// remaining space left after using all the spaces used to evenly distributed
		int extraSpace = diff % spaceNeeded;

		//using Strinh builder
		// start with adding first word n then add spaces
		StringBuilder res = new StringBuilder(words[i]);
		for (int k = i + 1; k < j; k++) {
			// add least space needed and if we have extra space
			int spacesToApply = leastSpaceNeed + (extraSpace > 0 ? 1 : 0);
			extraSpace--;
			//append spaces
			for (int l = 0; l < spacesToApply; l++) {
				res.append(" ");
			}
			// append next word
			res.append(words[k]);
		}

		return res.toString();
	}
}
