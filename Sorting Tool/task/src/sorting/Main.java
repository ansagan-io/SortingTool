package sorting;

import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static ArrayList<String> lines = new ArrayList<>();
    public static void main(final String[] args) {
        if(args[0].equals("-dataType")) {
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                lines.add(number);
            }
            if (args.length == 2){
                switch (args[1]) {
                    case "word": sortWords();
                        break;
                    case "long": sortLongs();
                        break;
                    case "line": sortLines();
                        break;
                }
            } else {
                sortWords();
            }
        }
    }

    private static void sortLines() {
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

        int percent = 0;

        try {
            percent = times * 100 / lines.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }

        System.out.printf("The longest line:\n%s\n(%d time(s), %d%%)", longestLine, times, percent);

    }

    private static void sortWords() {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : lines) {
            Scanner scan = new Scanner(s);
            while (scan.hasNext()){
                strings.add(scan.next());
            }
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

        int percent = 0;

        try {
            percent = times * 100 / strings.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }

        System.out.printf("The longest word: %s (%d time(s), %d%%)", max, times, percent);

    }

    private static void sortLongs() {
        ArrayList<Long> longs = new ArrayList<>();
        for (String s : lines) {
            Scanner scan = new Scanner(s);
            while (scan.hasNextLong()){
                longs.add(scan.nextLong());
            }
        }
        System.out.println("Total numbers: " + longs.size());

        int times = 0;

        long max = Collections.max(longs);
        for (long num :longs) {
            if (num == max){
                times++;
            }
        }
        int percent = 0;

        try {
            percent = times * 100 / longs.size();
        } catch (ArithmeticException e) {
            percent = 100;
        }
        System.out.printf("The greatest number: %d (%d time(s), %d%%)", max, times, percent);
    }
}
