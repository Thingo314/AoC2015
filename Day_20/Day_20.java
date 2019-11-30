import java.util.*;

public class Day_20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int threshold = sc.nextInt();
		sc.close();

		int[] houses1 = new int[threshold / 10];
		int[] houses2 = new int[threshold / 10];
		for (int i = 1; i < houses1.length; i++) {
			for (int j = i; j < houses1.length; j += i)
				houses1[j] += i * 10;
			for (int j = i; j / i <= 50 && j < houses2.length; j += i)
				houses2[j] += i * 11;
		}

		int part1 = 0;
		int part2 = 0;
		boolean foundPart1 = false;
		boolean foundPart2 = false;
	
		for (int i = 1; i < houses1.length; i++) {
			if (houses1[i] >= threshold && !foundPart1) {
				part1 = i;
				foundPart1 = true;
			}
			if (houses2[i] >= threshold && !foundPart2) {
				part2 = i;
				foundPart2 = true;
			}
		}

		System.out.println("Part 1: " + part1);
		System.out.println("Part 1: " + part2);
	}
}
