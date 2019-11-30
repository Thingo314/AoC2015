import java.util.*;

public class Day_16 {
	public static void main(String[] args) {
		HashMap<String, Integer> targetSue = new HashMap<>();
		targetSue.put("children", 3);
		targetSue.put("cats", 7);
		targetSue.put("samoyeds", 2);
		targetSue.put("pomeranians", 3);
		targetSue.put("akitas", 0);
		targetSue.put("vizslas", 0);
		targetSue.put("goldfish", 5);
		targetSue.put("trees", 3);
		targetSue.put("cars", 2);
		targetSue.put("perfumes", 1);

		String[] part1Sue = new String[1];
		String[] part2Sue = new String[1];

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] sue = sc.nextLine()
				.replace(",", "")
				.replace(":", "")
				.trim()
				.split(" ");

			boolean incorrectPart1Sue = false;
			boolean incorrectPart2Sue = false;

			for (int i = 2; i < sue.length; i += 2) {
				if (sue[i].equals("cats") || sue[i].equals("trees")) {
					if (targetSue.get(sue[i]) >= Integer.parseInt(sue[i + 1])) {
						incorrectPart2Sue = true;
					}
				} else if (sue[i].equals("pomeranians") || sue[i].equals("goldfish")) {
					if (targetSue.get(sue[i]) <= Integer.parseInt(sue[i + 1])) {
						incorrectPart2Sue = true;
					}
				} else {
					if (targetSue.get(sue[i]) != Integer.parseInt(sue[i + 1])) {
						incorrectPart2Sue = true;
					}
				}
				if (targetSue.get(sue[i]) != Integer.parseInt(sue[i + 1])) {
					incorrectPart1Sue = true;
				}
			}
			if (!incorrectPart1Sue) {
				part1Sue = sue;
			}
			if (!incorrectPart2Sue) {
				part2Sue = sue;
			}
		}
		sc.close();

		System.out.println("Part 1: " + part1Sue[1]);
		System.out.println("Part 2: " + part2Sue[1]);
	}
}
