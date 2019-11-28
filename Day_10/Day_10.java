import java.util.*;

public class Day_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		int part1 = 0;

		for (int i = 1; i <= 50; i++) {
			line = lookAndSay(line);
			if (i == 40)
				part1 = line.length();
		}

		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + line.length());
	}

	static String lookAndSay(String s) {
		if (s == null || s.length() <= 0)
			return "";

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < s.length();) {
			int num = 1;
			char c = s.charAt(i);

			while (i + num < s.length() && s.charAt(i + num) == c) {
				num++;
			}

			i += num;
			result.append(num);
			result.append(c);
		}

		return result.toString();
	}
}
