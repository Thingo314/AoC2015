import java.util.*;

public class Day_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();

		sc.close();

		int floor = 0;
		int character = 0;
		boolean enteredBasement = false;

		while (line.length() > 0) {
			if (!enteredBasement)
				character++;

			if (line.charAt(0) == '(') {
				floor++;
			} else {
				floor--;
			}

			if (floor == -1) {
				enteredBasement = true;
			}

			line = line.substring(1);
		}
		System.out.println("Part 1: " + floor);
		System.out.println("Part 2: " + character);
	}
}
