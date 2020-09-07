import java.util.*;

class SetUtils {

    /**
     * @return symmetric difference between set1 and set2
     */
    public static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        Set<String> newSet = new HashSet<>();
        for (String in:set1) {
            if (!set2.contains(in)) {
                newSet.add(in);
            }
        }
        for (String in:set2) {
            if (!set1.contains(in)) {
                newSet.add(in);
            }
        }
        return newSet;
    }

}

/* Do not change the code below */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String strSet1 = scanner.nextLine();
//        String strSet2 = scanner.nextLine();
//
//        Set<String> set1 = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
//
//        if (!Objects.equals(strSet1, "empty")) {
//            Collections.addAll(set1, strSet1.split("\\s+"));
//        }
//
//        if (!Objects.equals(strSet2, "empty")) {
//            Collections.addAll(set2, strSet2.split("\\s+"));
//        }
//
//        Set<String> resultSet = SetUtils.symmetricDifference(set1, set2);
//
//        System.out.println(String.join(" ", resultSet));


        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );

        for (Map.Entry<String, String> entry : friendPhones.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}