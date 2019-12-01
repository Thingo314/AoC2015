import java.util.*;

public class Day_23 {
	public static void main(String[] args) {
		ArrayList<String[]> instructions = new ArrayList<>();
		int[] registers = new int[2];
		int pointer = 0;

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine().replace(",", "");
			String[] instruction = line.split(" ");
			instructions.add(instruction);
		}
		sc.close();

		runProgram(registers, instructions);

		int part1 = registers[1];
		registers[0] = 1;
		registers[1] = 0;

		runProgram(registers, instructions);

		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + registers[1]);
	}

	static void runProgram(int[] registers, ArrayList<String[]> instructions) {
		int pointer = 0;

		while (pointer >= 0 && pointer < instructions.size()) {
			String[] instruction = instructions.get(pointer);
			int register = 0;
			if (instruction[1].equals("b"))
				register = 1;

			switch (instruction[0]) {
				case "jio":
					if (registers[register] == 1) {
						pointer += Integer.parseInt(instruction[2]);
					} else {
						pointer++;
					}
					break;
				case "jie":
					if (registers[register] % 2 == 0) {
						pointer += Integer.parseInt(instruction[2]);
					} else {
						pointer++;
					}
					break;
				case "jmp":
					pointer += Integer.parseInt(instruction[1]);
					break;
				case "inc":
					registers[register]++;
					pointer++;
					break;
				case "tpl":
					registers[register] *= 3;
					pointer++;
					break;
				case "hlf":
					registers[register] /= 2;
					pointer++;
					break;
			}
		}
	}
}
