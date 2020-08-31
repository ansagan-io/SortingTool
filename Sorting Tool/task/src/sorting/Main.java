package sorting;

import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        try {
            if(args[0].equals("-dataType")) {
                if (args.length == 2){
                    switch (args[args.length -1]) {
                        case "long": greatLongs();
                            break;
                        case "line": greatLines();
                            break;
                        case "-sortIntegers": sortIntegers();
                            break;
                        default:
                            greatWords();
                            break;
                    }
                }
            }else if (args[0].equals("-sortIntegers")) {
                sortIntegers();
            }
        } catch (IndexOutOfBoundsException e) {
            greatWords();
        }

    }

    private static void sortIntegers() {
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            integers.add(scanner.nextInt());
        }
        System.out.println("Total numbers: " + integers.size());
        Collections.sort(integers);
        System.out.print("Sorted data: ");
        for (Integer ints:integers
             ) {
            System.out.print(ints + " ");
        }
    }

    private static void greatLines() {
        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            lines.add(number);
        }

        System.out.println("Total lines: " + lines.size());

        String longestLine = "";

        for (String string: lines) {
            if (string.length() > longestLine.length()) {
                longestLine = string;
            }
        }

        int times = 0;

        for (String string: lines) {
            if (string.equals(longestLine)) {
                times++;
            }
        }

        int percent;

        try {
            percent = times * 100 / lines.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }

        System.out.printf("The longest line:\n%s\n(%d time(s), %d%%)", longestLine, times, percent);

    }

    private static void greatWords() {
        ArrayList<String> strings = new ArrayList<>();
        while (scanner.hasNext()){
            strings.add(scanner.next());
        }
        System.out.println("Total words: " + strings.size());

        String max = "";

        for (String string: strings) {
            if (string.length() > max.length()) {
                max = string;
            }
        }

        int times = 0;

        for (String string: strings) {
            if (string.equals(max)) {
                times++;
            }
        }

        int percent;

        try {
            percent = times * 100 / strings.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }

        System.out.printf("The longest word: %s (%d time(s), %d%%)", max, times, percent);

    }

    private static void greatLongs() {
        ArrayList<Long> longs = new ArrayList<>();
        while (scanner.hasNextLong()){
            longs.add(scanner.nextLong());
        }

        System.out.println("Total numbers: " + longs.size());

        int times = 0;

        long max = Collections.max(longs);
        for (long num :longs) {
            if (num == max){
                times++;
            }
        }
        int percent;

        try {
            percent = times * 100 / longs.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }
        System.out.printf("The greatest number: %d (%d time(s), %d%%)", max, times, percent);
    }
}
