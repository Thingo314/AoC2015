import java.util.*;

public class Day_21 {
	public static void main(String[] args) {
		ArrayList<Item> weapons = new ArrayList<Item>();
		weapons.add(new Item(8, 4, 0));
		weapons.add(new Item(10, 5, 0));
		weapons.add(new Item(25, 6, 0));
		weapons.add(new Item(40, 7, 0));
		weapons.add(new Item(74, 8, 0));

		ArrayList<Item> armor = new ArrayList<Item>();
		armor.add(new Item(0, 0, 0));
		armor.add(new Item(13, 0, 1));
		armor.add(new Item(31, 0, 2));
		armor.add(new Item(53, 0, 3));
		armor.add(new Item(75, 0, 4));
		armor.add(new Item(102, 0, 5));

		ArrayList<Item> rings = new ArrayList<Item>();
		rings.add(new Item(0, 0, 0));
		rings.add(new Item(0, 0, 0));
		rings.add(new Item(25, 1, 0));
		rings.add(new Item(50, 2, 0));
		rings.add(new Item(100, 3, 0));
		rings.add(new Item(20, 0, 1));
		rings.add(new Item(40, 0, 2));
		rings.add(new Item(80, 0, 3));

		int[] bossStats = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String[] line = sc.nextLine().split(" ");
			bossStats[i] = Integer.parseInt(line[line.length - 1]);
		}
		sc.close();

		int hp = 100;
		int bestWinningCost = Integer.MAX_VALUE;
		int worstLosingCost = Integer.MIN_VALUE;

		for (int i = 0; i < weapons.size(); i++) {
			for (int j = 0; j < armor.size(); j++) {
				for (int k = 0; k < rings.size(); k++) {
					for (int l = k + 1; l < rings.size(); l++) {
						int dmg = weapons.get(i).dmg + rings.get(k).dmg + rings.get(l).dmg;
						int amr = armor.get(j).amr + rings.get(k).amr + rings.get(l).amr;
						int cost = weapons.get(i).cost + armor.get(j).cost + rings.get(k).cost + rings.get(l).cost;

						int playerDmg = Math.max(1, dmg - bossStats[2]);
						int playerHits = bossStats[0] / playerDmg;
						if (bossStats[0] % playerDmg != 0)
							playerHits++;

						int bossDmg = Math.max(1, bossStats[1] - amr);
						int bossHits = hp / bossDmg;
						if (hp % bossDmg != 0)
							bossHits++;

						if (playerHits <= bossHits) {
							bestWinningCost = Math.min(bestWinningCost, cost);
						} else {
							worstLosingCost = Math.max(worstLosingCost, cost);
						}
					}
				}
			}
		}

		System.out.println("Part 1: " + bestWinningCost);
		System.out.println("Part 2: " + worstLosingCost);
	}
}

class Item {
	public int cost, dmg, amr;

	public Item(int c, int d, int a) {
		cost = c;
		dmg = d;
		amr = a;
	}
}
