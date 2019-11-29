import java.util.*;

public class Day_13 {
	public static void main(String[] args) {
		HashMap<ArrayList<String>, Integer> happinessChanges = new HashMap<>();
		ArrayList<String> names = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] edge = sc.nextLine().trim().split(" ");
			String nameA = edge[0];
			String nameB = edge[edge.length - 1];
			nameB = nameB.substring(0, nameB.length() - 1);
			int change = Integer.parseInt(edge[3]);
			if (edge[2].equals("lose"))
				change *= -1;

			happinessChanges.put(new ArrayList<>(Arrays.asList(nameA, nameB)), change);

			if (!names.contains(nameA))
				names.add(nameA);
			if (!names.contains(nameB))
				names.add(nameB);
		}
		sc.close();

		HashSet<Integer> routes = process(names, happinessChanges);

		int part1 = Integer.MIN_VALUE;
		for (Integer n : routes) {
			part1 = Math.max(part1, n);
		}

		String myName = "Me";

		for (String name : names) {
			happinessChanges.put(new ArrayList<>(Arrays.asList(myName, name)), 0);
			happinessChanges.put(new ArrayList<>(Arrays.asList(name, myName)), 0);
		}
		names.add(myName);

		routes = process(names, happinessChanges);

		int part2 = Integer.MIN_VALUE;
		for (Integer n : routes) {
			part2 = Math.max(part2, n);
		}

		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + part2);
	}

	static HashSet<Integer> process(ArrayList<String> l, HashMap<ArrayList<String>, Integer> d) {
		ArrayList<String> start = new ArrayList<>();
		for (String s : l)
			start.add(s);

		HashSet<Integer> results = new HashSet<>();

		do {
			int result = 0;

			for (int i = 0; i < l.size(); i++) {
				String a = l.get(i);
				String b = l.get((i + 1) % l.size());

				ArrayList<String> change1 = new ArrayList<>(Arrays.asList(a, b));
				ArrayList<String> change2 = new ArrayList<>(Arrays.asList(b, a));

				result += d.get(change1);
				result += d.get(change2);
			}

			results.add(result);
			permute(l);
		} while (!l.equals(start));

		return results;
	}

	static void permute(ArrayList<String> l) {
		if (l.size() <= 1)
			return;

		int last = l.size() - 2;
		while (last >= 0) {
			if (l.get(last).compareTo(l.get(last + 1)) < 0)
				break;
			last--;
		}

		if (last >= 0) {
			int larger = l.size() - 1;
			while (larger >= 0) {
				if (l.get(larger).compareTo(l.get(last)) > 0)
					break;
				larger--;
			}
			swap(l, last, larger);
		}

		reverse(l, last + 1);
	}

	static void swap(ArrayList<String> l, int a, int b) {
		String temp = l.get(a);
		l.set(a, l.get(b));
		l.set(b, temp);
	}

	static void reverse(ArrayList<String> l, int a) {
		int b = l.size() - 1;
		while (a < b) {
			swap(l, a, b);
			a++;
			b--;
		}
	}
}
