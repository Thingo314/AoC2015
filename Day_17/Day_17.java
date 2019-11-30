import java.util.*;

public class Day_17 {
	static int[] containersUsed = new int[1];

	public static void main(String[] args) {
		ArrayList<Integer> containers = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			containers.add(sc.nextInt());
		}
		sc.close();

		containersUsed = new int[containers.size() + 1];

		int part1 = count(containers, 0, 150, 0);
		int part2 = 0;
		for (int i = 0; i < containersUsed.length; i++) {
			if (containersUsed[i] != 0) {
				part2 = containersUsed[i];
				break;
			}
		}
		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + part2);
	}

	static int count(ArrayList<Integer> l, int index, int sum, int used) {
		if (sum == 0) {
			containersUsed[used]++;
			return 1;
		}

		if (sum < 0)
			return 0;

		if (index >= l.size())
			return 0;

		return count(l, index + 1, sum, used) + count(l, index + 1, sum - l.get(index), used + 1);
	}
}
