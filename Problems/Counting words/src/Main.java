import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> stringIntegerMap = new TreeMap<>();
        for (String s:strings) {
            if (stringIntegerMap.containsKey(s)) {
                stringIntegerMap.put(s, stringIntegerMap.get(s) + 1);
            } else {
                stringIntegerMap.put(s, 1);
            }
        }
        return stringIntegerMap;
    }

    public static void printMap(Map<String, Integer> map) {
        for (var pair:map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}