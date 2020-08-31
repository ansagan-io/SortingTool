import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        long[] ints = new long[i];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = scanner.nextInt();
        }

        System.out.println(mergeSortAndCount(ints, 0 , ints.length - 1));
    }

    private static long mergeAndCount(long[] arr, int l, int m, int r) {

        // Left subarray
        long[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function
    private static long mergeSortAndCount(long[] arr, int first, int last) {
        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        long count = 0;

        if (first < last) {
            int middle = (first + last) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, first, middle);

            // Right subarray count
            count += mergeSortAndCount(arr, middle + 1, last);

            // Merge count
            count += mergeAndCount(arr, first, middle, last);
        }
        return count;
    }

}