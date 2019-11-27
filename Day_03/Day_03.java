import java.util.*;

public class Day_03 {
	public static void main(String[] args) {
		HashSet<ArrayList<Integer>> houses = new HashSet<>();
		ArrayList<Integer> pos = new ArrayList<>(Arrays.asList(0, 0));
		houses.add(pos);

		HashSet<ArrayList<Integer>> dualHouses = new HashSet<>();
		ArrayList<Integer> santaPos = new ArrayList<>(Arrays.asList(0, 0));
		ArrayList<Integer> roboPos = new ArrayList<>(Arrays.asList(0, 0));
		dualHouses.add(santaPos);
		dualHouses.add(roboPos);

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			ArrayList<Integer> newPos = new ArrayList<>(pos);
			ArrayList<Integer> newDualPos = new ArrayList<>();
			if (i % 2 == 0) {
				newDualPos.addAll(santaPos);
			} else {
				newDualPos.addAll(roboPos);
			}
			
			switch (c) {
				case '^':
					newPos.set(1, newPos.get(1) + 1);
					newDualPos.set(1, newDualPos.get(1) + 1);
					break;
				case 'v':
					newPos.set(1, newPos.get(1) - 1);
					newDualPos.set(1, newDualPos.get(1) - 1);
					break;
				case '<':
					newPos.set(0, newPos.get(0) - 1);
					newDualPos.set(0, newDualPos.get(0) - 1);
					break;
				case '>':
					newPos.set(0, newPos.get(0) + 1);
					newDualPos.set(0, newDualPos.get(0) + 1);
					break;
			}

			houses.add(newPos);
			pos = newPos;

			dualHouses.add(newDualPos);
			if (i % 2 == 0) {
				santaPos = newDualPos;
			} else {
				roboPos = newDualPos;
			}
		}

		System.out.println("Part 1: " + houses.size());
		System.out.println("Part 2: " + dualHouses.size());
	}
}
