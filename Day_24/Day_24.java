import java.util.*;

public class Day_24 {
	public static void main(String[] args) {
		ArrayList<Integer> packages = new ArrayList<>();
		int total = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int pack = sc.nextInt();
			packages.add(pack);
			total += pack;
		}
		sc.close();

		int groupSum = total / 3;
		HashSet<ArrayList<Integer>> result = new HashSet<>();
		group(result, packages, new ArrayList<Integer>(), 0, groupSum);
		long part1 = findBestQE(result);
		
		groupSum = total / 4;
		result.clear();
		group(result, packages, new ArrayList<Integer>(), 0, groupSum);
		long part2 = findBestQE(result);
		
		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + part2);
	}

	static long arrayListProduct(ArrayList<Integer> l) {
		long result = 1;
		for (Integer n : l)
			result *= n;
		return result;
	}

	static long findBestQE(HashSet<ArrayList<Integer>> set) {
		long qe = Long.MAX_VALUE;
		ArrayList<Integer> group = null;
		for (ArrayList<Integer> list : set) {
			if (group == null || group.size() > list.size()) {
				group = list;
				qe = arrayListProduct(list);
			} else if (group.size() == list.size()) {
				long newQE = arrayListProduct(list);
				if (qe > newQE) {
					qe = newQE;
					group = list;
				}
			}

		}
		return qe;
	}

	static void group(HashSet<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> chosen, int index, int target) {
		if (target < 0)
			return;
		if (target == 0)
			result.add(chosen);
		if (index >= list.size())
			return;
		if (list.get(index) <= target) {
			ArrayList<Integer> newChosen = new ArrayList<>(chosen);
			newChosen.add(list.get(index));
			group(result, list, newChosen, index + 1, target - list.get(index));
		}
		group(result, list, chosen, index + 1, target);
	}
}
