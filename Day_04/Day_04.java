import java.math.BigInteger;
import java.security.*;
import java.util.*;

public class Day_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		int append = 1;
		int append5 = 0;
		int append6 = 0;
		boolean found5 = false;
		boolean found6 = false;

		while (!found5 || !found6) {
			String hash = getMD5(line + append);
			if (hash.startsWith("00000") && !found5) {
				append5 = append;
				found5 = true;
			}
			if (hash.startsWith("000000") && !found6) {
				append6 = append;
				found6 = true;
			}
			append++;
		}
		
		System.out.println("Part 1: " + append5);
		System.out.println("Part 2: " + append6);
	}

	static String getMD5(String in) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] message = md.digest(in.getBytes());
			BigInteger num = new BigInteger(1, message);
			String hash = num.toString(16);
			while (hash.length() < 32) {
				hash = "0" + hash;
			}
			return hash;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}
}
