import java.util.*;

public class Day_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		do {
			line = increment(line);
		} while (!isValidPassword(line));

		String pass1 = line;

		do {
			line = increment(line);
		} while (!isValidPassword(line));

		System.out.println("Part 1: " + pass1);
		System.out.println("Part 2: " + line);
	}

	static String increment(String s) {
		if (s == null)
			return "";

		StringBuilder sb = new StringBuilder(s);
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == 'z') {
				sb.setCharAt(i, 'a');
			} else {
				sb.setCharAt(i, (char) (sb.charAt(i) + 1));
				break;
			}
		}

		return sb.toString();
	}

	static boolean isValidPassword(String s) {
		if (s == null)
			return false;

		if (!contains3IncreasingLetters(s))
			return false;
		if (containsIllegalCharacter(s))
			return false;
		if (!containsTwoNonOverlappingPairs(s))
			return false;

		return true;
	}

	static boolean contains3IncreasingLetters(String s) {
		if (s == null)
			return false;

		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) - s.charAt(i + 1) == -1 && s.charAt(i + 1) - s.charAt(i + 2) == -1)
				return true;
		}

		return false;
	}

	static boolean containsIllegalCharacter(String s) {
		if (s == null)
			return false;

		if (s.contains("i"))
			return true;
		if (s.contains("o"))
			return true;
		if (s.contains("l"))
			return true;

		return false;
	}

	static boolean containsTwoNonOverlappingPairs(String s) {
		if (s == null)
			return false;

		boolean foundPair = false;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				if (foundPair) {
					return true;
				}
				foundPair = true;
				i++;
			}
		}

		return false;
	}
}
