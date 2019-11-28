import java.util.*;

public class Day_08 {
	public static void main(String[] args) {
		int charsOfCode = 0;
		int charsOfData = 0;
		int charsOfNewCode = 0;

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String code = sc.nextLine();
			charsOfCode += code.length();
			charsOfData += getNumCharacters(code);

			String newCode = "\"" + encodeNewString(code) + "\"";
			charsOfNewCode += newCode.length();
		}
		sc.close();

		System.out.println("Part 1: " + (charsOfCode - charsOfData));
		System.out.println("Part 2: " + (charsOfNewCode - charsOfCode));
	}

	static int getNumCharacters(String s) {
		if (s == null || s.length() <= 0)
			return 0;

		if (s.charAt(0) == '\\') {
			if (s.charAt(1) == 'x') {
				return 1 + getNumCharacters(s.substring(4));
			}
			return 1 + getNumCharacters(s.substring(2));
		} else if (s.charAt(0) == '"') {
			return getNumCharacters(s.substring(1));
		}

		return 1 + getNumCharacters(s.substring(1));
	}

	static String encodeNewString(String s) {
		if (s == null || s.length() <= 0)
			return "";

		if (s.charAt(0) == '"')
			return "\\\"" + encodeNewString(s.substring(1));

		if (s.charAt(0) == '\\')
			return "\\\\" + encodeNewString(s.substring(1));

		return s.charAt(0) + encodeNewString(s.substring(1));
	}
}
