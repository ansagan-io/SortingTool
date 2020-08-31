

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int ras = scanner.nextInt();
            for (int j = 0; j < ras; j++) {
                integers.add(scanner.nextInt());
            }
        }

        int[] intg = new int[integers.size()];
        for (int i=0; i < intg.length; i++) {
            intg[i] = integers.get(i);
        }

        mergeSort(intg, 0, intg.length);

        for (Integer ints:intg) {
            System.out.print(ints + " ");
        }
    }

    private static void mergeSort(int[] integers, int left, int right) {
        if (right <= left + 1){
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(integers, left, middle);
        mergeSort(integers, middle, right);

        merge(integers, left, middle, right);
    }

    private static void merge(int[] integers, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;

        int[] temp = new int[right - left];

        while (i < middle && j < right) {
            if (integers[i] > integers[j]) {
                temp[k] = integers[i];
                i++;
            } else {
                temp[k] = integers[j];
                j++;
            }
            k++;
        }

        System.arraycopy(integers, i, temp, k, middle - i);
        System.arraycopy(integers, j, temp, k, right - j);
        System.arraycopy(temp, 0, integers, left, temp.length);
    }
}