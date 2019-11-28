import java.util.*;

public class Day_09 {
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> distances = new HashMap<>();
		ArrayList<String> locations = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] edge = sc.nextLine().trim().split(" ");
			String locationA = edge[0];
			String locationB = edge[2];
			int distance = Integer.parseInt(edge[4]);

			if (!distances.containsKey(locationA)) {
				distances.put(locationA, new HashMap<>());
			}

			distances.get(locationA).put(locationB, distance);
			if (!locations.contains(locationA))
				locations.add(locationA);
			if (!locations.contains(locationB))
				locations.add(locationB);
		}
		sc.close();

		HashSet<Integer> routes = process(locations, distances);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (Integer n : routes) {
			min = Math.min(min, n);
			max = Math.max(max, n);
		}

		System.out.println("Part 1: " + min);
		System.out.println("Part 2: " + max);
	}

	static HashSet<Integer> process(ArrayList<String> l, HashMap<String, HashMap<String, Integer>> d) {
		ArrayList<String> start = new ArrayList<>();
		for (String s : l)
			start.add(s);

		HashSet<Integer> results = new HashSet<>();

		do {
			int result = 0;

			for (int i = 0; i < l.size() - 1; i++) {
				String a = l.get(i);
				String b = l.get(i + 1);

				if (d.containsKey(a) && d.get(a).containsKey(b)) {
					result += d.get(a).get(b);
				} else {
					result += d.get(b).get(a);
				}
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
