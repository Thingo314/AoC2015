import java.util.*;

public class Day_06 {
	public static void main(String[] args) {
		int dimensions = 1000;
		boolean[][] lights = new boolean[dimensions][dimensions];
		int[][] lightBrightnesses = new int[dimensions][dimensions];

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().trim().split(" ");
			if (line[0].equals("toggle")) {
				String[] min = line[1].split(",");
				String[] max = line[3].split(",");
				int minX = Integer.parseInt(min[0]);
				int minY = Integer.parseInt(min[1]);
				int maxX = Integer.parseInt(max[0]);
				int maxY = Integer.parseInt(max[1]);
				for (int x = minX; x <= maxX; x++) {
					for (int y = minY; y <= maxY; y++) {
						lights[x][y] = !lights[x][y];
						lightBrightnesses[x][y] += 2;
					}
				}
			} else {
				boolean set = false;
				int diff = -1;
				if (line[1].equals("on")) {
					set = true;
					diff = 1;
				}
				String[] min = line[2].split(",");
				String[] max = line[4].split(",");
				int minX = Integer.parseInt(min[0]);
				int minY = Integer.parseInt(min[1]);
				int maxX = Integer.parseInt(max[0]);
				int maxY = Integer.parseInt(max[1]);
				for (int x = minX; x <= maxX; x++) {
					for (int y = minY; y <= maxY; y++) {
						lights[x][y] = set;
						lightBrightnesses[x][y] = Math.max(lightBrightnesses[x][y] + diff, 0);
					}
				}
			}
		}
		sc.close();

		int lightsLit = 0;
		int lightBrightness = 0;

		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[0].length; j++) {
				if (lights[i][j])
					lightsLit++;
				lightBrightness += lightBrightnesses[i][j];
			}
		}

		System.out.println("Part 1: " + lightsLit);
		System.out.println("Part 2: " + lightBrightness);
	}
}
