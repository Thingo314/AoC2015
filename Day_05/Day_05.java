import java.util.*;

public class Day_05 {
	static String[] badStrings = {"ab", "cd", "pq", "xy"};

	public static void main(String[] args) {
		int niceStrings1 = 0;
		int niceStrings2 = 0;

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (isNice1(line))
				niceStrings1++;
			if (isNice2(line))
				niceStrings2++;

		}
		sc.close();

		System.out.println("Part 1: " + niceStrings1);
		System.out.println("Part 2: " + niceStrings2);
	}

	static boolean isNice1(String s) {
		if (s == null)
			return false;
		if (!containsThreeVowels(s))
			return false;
		if (!containsLettersInARow(s))
			return false;
		if (containsBadSubstring(s))
			return false;
		return true;
	}

	static boolean isNice2(String s) {
		if (s == null)
			return false;
		if (!containsNonOverlappingPair(s))
			return false;
		if (!containsRepeatingLetterWithGap(s))
			return false;
		return true;
	}

	static boolean containsThreeVowels(String s) {
		if (s == null)
			return false;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if ("aeiou".indexOf(s.charAt(i)) != -1)
				result++;
			if (result >= 3)
				return true;
		}
		return false;
	}

	static boolean containsLettersInARow(String s) {
		if (s == null)
			return false;
		if (s.length() < 2)
			return false;

		if (s.charAt(0) == s.charAt(1))
			return true;
		return containsLettersInARow(s.substring(1));
	}

	static boolean containsBadSubstring(String s) {
		if (s == null)
			return false;

		for (String badString : badStrings)
			if (s.contains(badString))
				return true;

		return false;
	}

	static boolean containsNonOverlappingPair(String s) {
		if (s == null)
			return false;
		if (s.length() < 2)
			return false;

		String pairToConsider = s.substring(0, 2);
		String restOfString = s.substring(2);
		if (restOfString.contains(pairToConsider))
			return true;

		return containsNonOverlappingPair(s.substring(1));
	}

	static boolean containsRepeatingLetterWithGap(String s) {
		if (s == null)
			return false;
		if (s.length() < 3)
			return false;

		if (s.charAt(0) == s.charAt(2))
			return true;
		return containsRepeatingLetterWithGap(s.substring(1));
	}
}
