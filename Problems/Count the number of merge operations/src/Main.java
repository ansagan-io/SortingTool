import java.util.*;

public class Main {
    static int n = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        mergeSort(arr, 0, arr.length);

        System.out.println(n);
    }

    private static void mergeSort(int[] arr, int leftIncl, int rightExcl) {
        if (rightExcl <= leftIncl + 1) {
            return;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(arr, leftIncl, middle);
        mergeSort(arr, middle, rightExcl);

        merge(arr, leftIncl, middle, rightExcl);
    }

    private static void merge(int[] arr, int leftIncl, int middle, int rightExcl) {
        int i = leftIncl;
        int j = middle;
        int k = 0;

        int[] temp = new int[rightExcl - leftIncl];

        while (i < middle && j < rightExcl) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        System.arraycopy(arr, i, temp, k, middle - i);
        System.arraycopy(arr, i, temp, k, rightExcl - j);

        System.arraycopy(temp, 0, arr, leftIncl, temp.length);
        n++;
    }

}