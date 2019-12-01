import java.util.*;

public class Day_25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine().replace(",", "").replace(".", "");
		String[] words = line.trim().split(" ");
		sc.close();

		int targetRow = Integer.parseInt(words[words.length - 3]);
		int targetCol = Integer.parseInt(words[words.length - 1]);

		int row = 1;
		int col = 1;
		long val = 20151125;

		while (row != targetRow || col != targetCol) {
			row--;
			col++;
			if (row == 0) {
				row = col;
				col = 1;
			}
			val *= 252533;
			val %= 33554393;
		}
		System.out.println("Part 1: " + val);
		System.out.println("Part 2: Have a fantatic new year!");
	}
}
