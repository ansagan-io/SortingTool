package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        String dataType = "word";
        String sortType = "natural";
        String inputFile = null;
        String outputFile = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                try {
                    dataType = args[i + 1];
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No data type defined!");
                    System.exit(0);
                }
            }

            if (args[i].equals("-sortingType")) {
                try {
                    sortType = args[i + 1];
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No sorting type defined!");
                    System.exit(0);
                }
            }

            if (args[i].equals("-inputFile")) {
                try {
                    inputFile = args[i + 1];
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No input file defined!");
                    System.exit(0);
                }
            }
            if (args[i].equals("-outputFile")) {
                try {
                    outputFile = args[i + 1];
                    i++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No output file defined!");
                    System.exit(0);
                }
            }

            if (args[i].startsWith("-")) {
                System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped");
            }
        }

        switch (Objects.requireNonNull(dataType)) {
            case "long":
                sortLongs(sortType, inputFile, outputFile);
                break;
            case "line":
                sortLines(sortType, inputFile, outputFile);
                break;
            case "word":
                sortWords(sortType, inputFile, outputFile);
                break;
        }
    }

    private static void sortLines(String sortType, String inputFile, String outputFile) {
        ArrayList<String> sortedDataEntries = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        if (inputFile != null) {
            File file = new File(inputFile);
            try (Scanner fileScan = new Scanner(file)) {
                while (fileScan.hasNextLine()) {
                    sortedDataEntries.add(fileScan.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Some error occurred: " + e.getMessage());
                System.exit(0);
            }
        } else {
            while (scanner.hasNextLine()) {
                sortedDataEntries.add(scanner.nextLine());
            }
        }

        output.append("Total lines: ").append(sortedDataEntries.size()).append("\n");
        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            output.append("Sorted data: \n");
            for (String line : sortedDataEntries) {
                output.append(line).append("\n");
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
                    output.append(String.format("%s: %d time(s), %d%%\n", line, pairs.getKey(), percent));
                }
            }


        }

        if (outputFile != null) {
            File file = new File(outputFile);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.append(output);
            } catch (IOException e) {
                System.out.println("Some error occurred: " + e.getMessage());
                System.exit(0);
            }
        } else {
            System.out.println(output);
        }
    }

    private static void sortWords(String sortType, String inputFile, String outputFile) {
        ArrayList<String> sortedDataEntries = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        if (inputFile != null) {
            File file = new File(inputFile);
            try (Scanner fileScan = new Scanner(file)) {
                while (fileScan.hasNext()) {
                    sortedDataEntries.add(fileScan.next());
                }
            } catch (IOException e) {
                System.out.println("Some error occurred: " + e.getMessage());
                System.exit(0);
            }
        } else {
            while (scanner.hasNext()) {
                sortedDataEntries.add(scanner.next());
            }
        }

        output.append("Total words: ").append(sortedDataEntries.size()).append("\n");

        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            output.append("Sorted data: ");
            for (String word : sortedDataEntries) {
                output.append(word).append(" ");
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
                    output.append(String.format("%s: %d time(s), %d%%\n", word, pairs.getKey(), percent));
                }
            }

            if (outputFile != null) {
                File file = new File(outputFile);
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.append(output);
                } catch (IOException e) {
                    System.out.println("Some error occurred: " + e.getMessage());
                    System.exit(0);
                }
            } else {
                System.out.println(output);
            }
        }
    }

    private static void sortLongs(String sortType, String inputFile, String outputFile) {
        ArrayList<Long> sortedDataEntries = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        if (inputFile != null) {
            File file = new File(inputFile);
            try (Scanner fileScan = new Scanner(file)) {
                while (fileScan.hasNext()) {
                    String beParsed = fileScan.next();
                    try {
                        long number = Long.parseLong(beParsed);
                        sortedDataEntries.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("\"" + beParsed + "\" isn't a long. It's skipped");
                    }
                }
            } catch (IOException e) {
                System.out.println("Some error occurred: " + e.getMessage());
                System.exit(0);
            }
        } else {
            while (scanner.hasNext()) {
                String beParsed = scanner.next();
                try {
                    long number = Long.parseLong(beParsed);
                    sortedDataEntries.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("\"" + beParsed + "\" isn't a long. It's skipped");
                }

            }
        }

        output.append("Total numbers: ").append(sortedDataEntries.size()).append("\n");
        Collections.sort(sortedDataEntries);

        if (sortType.equals("natural")) {

            output.append("Sorted data: ");
            for (Long ints : sortedDataEntries) {
                output.append(ints).append(" ");
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
                    output.append(String.format("%d: %d time(s), %d%%\n", number, pairs.getKey(), percent));
                }
            }
        }

        if (outputFile != null) {
            File file = new File(outputFile);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.append(output);
            } catch (IOException e) {
                System.out.println("Some error occurred: " + e.getMessage());
                System.exit(0);
            }
        } else {
            System.out.println(output);
        }
    }
}