import java.util.*;

public class Day_18 {
	public static void main(String[] args) {
		int dimensions = 100;
		int iterations = 100;
		boolean[][] lightsPart1 = new boolean[dimensions][dimensions];
		boolean[][] lightsPart2 = new boolean[dimensions][dimensions];

		Scanner sc = new Scanner(System.in);
		for (int row = 0; row < dimensions; row++) {
			String line = sc.nextLine();
			for (int col = 0; col < dimensions; col++) {
				if (line.charAt(col) == '#') {
					lightsPart1[row][col] = true;
					lightsPart2[row][col] = true;
				}
				if ((row == 0 || row == dimensions - 1) && (col == 0 || col == dimensions - 1))
					lightsPart2[row][col] = true;
			}
		}
		sc.close();

		for (int i = 0; i < iterations; i++) {
			boolean[][] nextStatePart1 = new boolean[dimensions][dimensions];
			boolean[][] nextStatePart2 = new boolean[dimensions][dimensions];
			for (int row = 0; row < dimensions; row++) {
				for (int col = 0; col < dimensions; col++) {
					int lightsSetPart1 = 0;
					int lightsSetPart2 = 0;
					for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
						if (row + rowOffset < 0 || row + rowOffset >= dimensions)
							continue;
						for (int colOffset = -1; colOffset <= 1; colOffset++) {
							if (col + colOffset < 0 || col + colOffset >= dimensions)
								continue;
							if (rowOffset == 0 && colOffset == 0)
								continue;
							if (lightsPart1[row + rowOffset][col + colOffset])
								lightsSetPart1++;
							if (lightsPart2[row + rowOffset][col + colOffset])
								lightsSetPart2++;
						}
					}

					if (lightsPart1[row][col]) {
						if (lightsSetPart1 < 2 || lightsSetPart1 > 3) {
							nextStatePart1[row][col] = false;
						} else {
							nextStatePart1[row][col] = true;
						}
					} else {
						if (lightsSetPart1 == 3) {
							nextStatePart1[row][col] = true;
						}
					}
					if (lightsPart2[row][col]) {
						if (lightsSetPart2 < 2 || lightsSetPart2 > 3) {
							nextStatePart2[row][col] = false;
						} else {
							nextStatePart2[row][col] = true;
						}
					} else {
						if (lightsSetPart2 == 3) {
							nextStatePart2[row][col] = true;
						}
					}

					if ((row == 0 || row == dimensions - 1) && (col == 0 || col == dimensions - 1))
						nextStatePart2[row][col] = true;
				}
			}
			lightsPart1 = nextStatePart1;
			lightsPart2 = nextStatePart2;
		}

		int countPart1 = 0;
		int countPart2 = 0;
		for (int row = 0; row < dimensions; row++) {
			for (int col = 0; col < dimensions; col++) {
				if (lightsPart1[row][col])
					countPart1++;
				if (lightsPart2[row][col])
					countPart2++;
			}
		}

		System.out.println("Part 1: " + countPart1);
		System.out.println("Part 2: " + countPart2);
	}
}
