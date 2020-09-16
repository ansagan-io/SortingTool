package sorting;


import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        int sortIndex = 0;
        int dataIndex = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                dataIndex = i;
            }
            if (args[i].equals("-sortingType")) {
                sortIndex = i;
            }
        }

        String dataType;
        String sortType;

        try {
            if (!args[dataIndex + 1].equals("word") && !args[dataIndex + 1].equals("line") && !args[dataIndex + 1].equals("long"))
                dataType = "word";
            else
                dataType = args[dataIndex + 1];
        } catch (IndexOutOfBoundsException e) {
            dataType = "word";
        }

        try {
            if (!args[sortIndex + 1].equals("natural") && !args[sortIndex + 1].equals("byCount")) {
                sortType = "natural";
            } else {
                sortType = args[sortIndex + 1];
            }
        } catch (IndexOutOfBoundsException e) {
            sortType = "natural";
        }

        switch (dataType) {
            case "long":
                sortLongs(sortType);
                break;
            case "line":
                sortLines(sortType);
                break;
            case "word":
                sortWords(sortType);
                break;
        }

    }

    private static void sortLines(String sortType) {
        ArrayList<String> sortedDataEntries = new ArrayList<>();
        while (scanner.hasNextLine()) {
            sortedDataEntries.add(scanner.nextLine());
        }
        System.out.println("Total lines: " + sortedDataEntries.size());
        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            System.out.print("Sorted data: \n");
            for (String line : sortedDataEntries) {
                System.out.println(line);
            }
        } else {
            HashMap<String, Integer> dataEntryToCount = new HashMap<>();

            for (String word : sortedDataEntries) {
                dataEntryToCount.put(word, dataEntryToCount.getOrDefault(word, 0) + 1);
            }

            HashMap<Integer, TreeSet<String>> countToDataEntries = new HashMap<>();
            for (HashMap.Entry<String, Integer> pairs : dataEntryToCount.entrySet()) {
                if (countToDataEntries.containsKey(pairs.getValue())) {
                    countToDataEntries.get(pairs.getValue()).add(pairs.getKey());
                } else {
                    countToDataEntries.put(pairs.getValue(), new TreeSet<>(Collections.singletonList(pairs.getKey())));
                }

            }

            for (HashMap.Entry<Integer, TreeSet<String>> pairs : countToDataEntries.entrySet()) {
                for (String line : pairs.getValue()) {
                    int percent = (100 / sortedDataEntries.size()) * pairs.getKey();
                    System.out.printf("%s: %d time(s), %d%%\n", line, pairs.getKey(), percent);
                }
            }
        }
    }

    private static void sortWords(String sortType) {
        ArrayList<String> sortedDataEntries = new ArrayList<>();
        while (scanner.hasNext()) {
            sortedDataEntries.add(scanner.next());
        }
        System.out.println("Total words: " + sortedDataEntries.size());
        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            System.out.print("Sorted data: ");
            for (String word : sortedDataEntries) {
                System.out.print(word + " ");
            }
        } else {
            Map<String, Integer> dataEntryToCount = new HashMap<>();

            for (String word : sortedDataEntries) {
                dataEntryToCount.put(word, dataEntryToCount.getOrDefault(word, 0) + 1);
            }

            Map<Integer, Set<String>> countToDataEntries = new HashMap<>();
            for (Map.Entry<String, Integer> pairs : dataEntryToCount.entrySet()) {
                if (countToDataEntries.containsKey(pairs.getValue())) {
                    countToDataEntries.get(pairs.getValue()).add(pairs.getKey());
                } else {
                    countToDataEntries.put(pairs.getValue(), new TreeSet<>(Collections.singletonList(pairs.getKey())));
                }
            }

            for (Map.Entry<Integer, Set<String>> pairs : countToDataEntries.entrySet()) {
                for (String word : pairs.getValue()) {
                    int percent = (100 / sortedDataEntries.size()) * pairs.getKey();
                    System.out.printf("%s: %d time(s), %d%%\n", word, pairs.getKey(), percent);
                }
            }
        }
    }

    private static void sortLongs(String sortType) {
        ArrayList<Long> sortedDataEntries = new ArrayList<>();
        while (scanner.hasNextLong()) {
            sortedDataEntries.add(scanner.nextLong());
        }
        System.out.println("Total numbers: " + sortedDataEntries.size());
        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            System.out.print("Sorted data: ");
            for (Long ints : sortedDataEntries) {
                System.out.print(ints + " ");
            }
        } else {
            Map<Long, Integer> dataEntryToCount = new HashMap<>();

            for (Long number : sortedDataEntries) {
                dataEntryToCount.put(number, dataEntryToCount.getOrDefault(number, 0) + 1);
            }

            Map<Integer, Set<Long>> countToDataEntries = new HashMap<>();
            for (Map.Entry<Long, Integer> pairs : dataEntryToCount.entrySet()) {
                if (countToDataEntries.containsKey(pairs.getValue())) {
                    countToDataEntries.get(pairs.getValue()).add(pairs.getKey());
                } else {
                    countToDataEntries.put(pairs.getValue(), new TreeSet<>(Collections.singletonList(pairs.getKey())));
                }
            }

            for (Map.Entry<Integer, Set<Long>> pairs : countToDataEntries.entrySet()) {
                for (Long number : pairs.getValue()) {
                    int percent = (100 / sortedDataEntries.size()) * pairs.getKey();
                    System.out.printf("%d: %d time(s), %d%%\n", number, pairs.getKey(), percent);
                }
            }
        }
    }
}