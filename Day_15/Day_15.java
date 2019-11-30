import java.util.*;

public class Day_15 {
	public static void main(String[] args) {
		int[][] ingredients = new int[4][5];
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().replace(",", "").trim().split(" ");
			for (int i = 2; i < line.length; i += 2) {
				ingredients[num][i / 2 - 1] = Integer.parseInt(line[i]);
			}
			num++;
		}
		sc.close();

		int highestScore = 0;
		int highest500CalorieScore = 0;

		for (int a = 0; a <= 100; a++) {
			for (int b = 0; a + b <= 100; b++) {
				for (int c = 0; a + b + c <= 100; c++) {
					int d = 100 - a - b - c;

					int result = 1;
					for (int i = 0; i < 4; i++) {
						int property = a * ingredients[0][i]
							+ b * ingredients[1][i]
							+ c * ingredients[2][i]
							+ d * ingredients[3][i];
						if (property <= 0) {
							result = 0;
							break;
						}
						result *= property;
					}
					int calories = a * ingredients[0][4]
						+ b * ingredients[1][4]
						+ c * ingredients[2][4]
						+ d * ingredients[3][4];

					highestScore = Math.max(highestScore, result);
					if (calories == 500)
						highest500CalorieScore = Math.max(highest500CalorieScore, result);
				}
			}
		}

		System.out.println("Part 1: " + highestScore);
		System.out.println("Part 2: " + highest500CalorieScore);
	}
}
