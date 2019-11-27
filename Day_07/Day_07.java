import java.util.*;

public class Day_07 {
	static HashMap<String, String[]> instructionSet = new HashMap<>();
	static HashMap<String, Character> result = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" -> ");
			String wire = line[1];
			String[] instruction = line[0].split(" ");

			instructionSet.put(wire, instruction);
		}
		sc.close();

		evaluateWire("a");
		System.out.println("Part 1: " + (int) result.get("a"));

		char newB = result.get("a");
		result.clear();
		result.put("b", newB);
		evaluateWire("a");
		System.out.println("Part 2: " + (int) result.get("a"));

	}

	static void evaluateWire(String wire) {
		if (result.containsKey(wire))
			return;

		String[] instruction = instructionSet.get(wire);
		char value = 0;
		switch (instruction.length) {
			case 1:
				if (isNumeric(instruction[0])) {
					value = (char) Integer.parseInt(instruction[0]);
					result.put(wire, value);
					return;
				} else {
					evaluateWire(instruction[0]);
					value = result.get(instruction[0]);
					result.put(wire, value);
					return;
				}
			case 2:
				evaluateWire(instruction[1]);
				value = (char) ~result.get(instruction[1]);
				result.put(wire, value);
				return;
			case 3:
				String function = instruction[1];

				char a = 0;
				char b = 0;
				
				if (isNumeric(instruction[0])) {
					a = (char) Integer.parseInt(instruction[0]);
				} else {
					evaluateWire(instruction[0]);
					a = result.get(instruction[0]);
				}

				if (isNumeric(instruction[2])) {
					b = (char) Integer.parseInt(instruction[2]);
				} else {
					evaluateWire(instruction[2]);
					b = result.get(instruction[2]);
				}

				switch (function) {
					case "AND":
						value = (char) (a & b);
						break;
					case "OR":
						value = (char) (a | b);
						break;
					case "LSHIFT":
						value = (char) (a << b);
						break;
					case "RSHIFT":
						value = (char) (a >>> b);
						break;
				}

				result.put(wire, value);
				return;
		}
	}

	static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
