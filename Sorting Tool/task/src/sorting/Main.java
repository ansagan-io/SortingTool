package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Long> longs = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            longs.add(number);
        }

        System.out.println("Total numbers: " + longs.size());
        int times = 0;
        long max = Collections.max(longs);
        for (long longg:longs
             ) {
            if (longg == max){
                times++;
            }
        }
        System.out.printf("The largest number: %d (%d time(s))", max, times);
    }
}
