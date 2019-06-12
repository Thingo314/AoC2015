import java.util.*;

public class Day_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalWrappingPaper = 0;
		int totalRibbon = 0;

		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().trim().split("x");
			
			int[] dimensions = new int[line.length];
			for (int i = 0; i < dimensions.length; i++) {
				dimensions[i] = Integer.parseInt(line[i]);
			}

			int lw = dimensions[0] * dimensions[1];
			int lh = dimensions[0] * dimensions[2];
			int wh = dimensions[1] * dimensions[2];

			int slack = Math.min(lw, lh);
			slack = Math.min(slack, wh);

			int box = 2 * (lw + lh + wh) + slack;

			totalWrappingPaper += box;

			int ribbon = dimensions[0] + dimensions[1] + dimensions[2];
			int maxDimension = Math.max(dimensions[0], dimensions[1]);
			maxDimension = Math.max(maxDimension, dimensions[2]);

			ribbon -= maxDimension;
			ribbon *= 2;

			int bow = dimensions[0] * dimensions[1] * dimensions[2];

			totalRibbon += bow + ribbon;

		}
		System.out.println("Part 1: " + totalWrappingPaper);
		System.out.println("Part 2: " + totalRibbon);

		sc.close();
	}
}
