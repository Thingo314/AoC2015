import java.util.*;

public class Day_14 {
	public static void main(String[] args) {
		int raceTime = 2503;
		HashMap<Reindeer, Integer> distances = new HashMap<>();
		HashMap<Reindeer, Integer> points = new HashMap<>();
		HashMap<Reindeer, Integer> timeInMode = new HashMap<>();
		HashMap<Reindeer, Boolean> isResting = new HashMap<>();
		ArrayList<Reindeer> reindeers = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().trim().split(" ");
			String name = line[0];
			int speed = Integer.parseInt(line[3]);
			int travelTime = Integer.parseInt(line[6]);
			int restTime = Integer.parseInt(line[13]);

			Reindeer reindeer = new Reindeer(speed, travelTime, restTime, name);
			distances.put(reindeer, 0);
			points.put(reindeer, 0);
			timeInMode.put(reindeer, 0);
			isResting.put(reindeer, false);
			reindeers.add(reindeer);
		}
		sc.close();

		int furthestDistance = 0;
		int highestPoints = 0;
		for (int i = 0; i < raceTime; i++) {
			for (Reindeer reindeer : reindeers) {
				if (isResting.get(reindeer)) {
					if (timeInMode.get(reindeer) < reindeer.restTime) {
						timeInMode.put(reindeer, timeInMode.get(reindeer) + 1);
					} else {
						timeInMode.put(reindeer, 1);
						isResting.put(reindeer, false);
						int newDistance = distances.get(reindeer) + reindeer.speed;
						distances.put(reindeer, newDistance);
						furthestDistance = Math.max(furthestDistance, newDistance);
					}
				} else {
					if (timeInMode.get(reindeer) < reindeer.travelTime) {
						timeInMode.put(reindeer, timeInMode.get(reindeer) + 1);
						int newDistance = distances.get(reindeer) + reindeer.speed;
						distances.put(reindeer, newDistance);
						furthestDistance = Math.max(furthestDistance, newDistance);
					} else {
						timeInMode.put(reindeer, 1);
						isResting.put(reindeer, true);
					}
				}
			}

			for (Map.Entry<Reindeer, Integer> distance : distances.entrySet()) {
				if (distance.getValue() == furthestDistance) {
					Reindeer reindeerAhead = distance.getKey();
					int newPoint = points.get(reindeerAhead) + 1;
					points.put(reindeerAhead, newPoint);
					highestPoints = Math.max(highestPoints, newPoint);
				}
			}
		}

		System.out.println("Part 1: " + furthestDistance);
		System.out.println("Part 2: " + highestPoints);
	}
}

class Reindeer {
	public int speed, travelTime, restTime;
	public String name;

	public Reindeer(int s, int t, int r, String n) {
		speed = s;
		travelTime = t;
		restTime = r;
		name = n;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reindeer))
			return false;

		Reindeer r = (Reindeer) o;
		return speed == r.speed
			&& travelTime == r.travelTime
			&& restTime == r.restTime
			&& name.equals(r.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(speed, travelTime, restTime, name);
	}
}
