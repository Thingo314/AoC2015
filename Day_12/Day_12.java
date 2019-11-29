import java.util.*;

// JSON library for java
// can be found at https://github.com/stleary/JSON-java
import org.json.*;

public class Day_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        JSONObject object = new JSONObject(line);

        int part1 = getValue(object, false);
        int part2 = getValue(object, true);
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }

    static int getValue(Object o, boolean ignoreRed) {
        if (o instanceof Integer)
            return (int) o;
        if (o instanceof String)
            return 0;

        int total = 0;
        if (o instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) o;
            for (int i = 0; i < jsonArray.length(); i++) {
                total += getValue(jsonArray.get(i), ignoreRed);
            }
            return total;
        }

        if (o instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) o;
            String[] names = JSONObject.getNames(jsonObject);

            for (int i = 0; i < names.length; i++) {
                if (ignoreRed) {
                    if (jsonObject.get(names[i]).equals("red")) {
                        return 0;
                    }
                }
                total += getValue(jsonObject.get(names[i]), ignoreRed);
            }
            return total;
        }

        return 0;
    }
}
