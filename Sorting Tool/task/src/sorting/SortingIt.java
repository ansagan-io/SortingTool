package sorting;

import java.util.ArrayList;

public class SortingIt<T> {
    private final ArrayList<T> sortableArray = new ArrayList<>();

    public void add(T element) {
        sortableArray.add(element);
    }

    public void sort() {
        int left = 0;
        int right = sortableArray.size();
        T[] array = (T[]) new Object[right];

        mergeSort(sortableArray, left, right);
    }

    private void mergeSort(ArrayList<T> sortableArray, int left, int right) {
    }

    private void mergeSort(String[] strings, int left, int right) {
        if (right <= left + 1) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(strings, left, middle);
        mergeSort(strings, middle, right);

        merge(strings, left, middle, right);
    }

    private void mergeSort(int[] integers, int left, int right) {
        if (right <= left + 1) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(integers, left, middle);
        mergeSort(integers, middle, right);

        merge(integers, left, middle, right);
    }

    private void merge(String[] strings, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;

        String[] temp = new String[right - left];

        while (i < middle && j < right) {
            if (strings[i].compareTo(strings[j]) < 0) {
                temp[k] = strings[i];
                i++;
            } else {
                temp[k] = strings[j];
                j++;
            }
            k++;
        }

        System.arraycopy(strings, i, temp, k, middle - i);
        System.arraycopy(strings, j, temp, k, right - j);
        System.arraycopy(temp, 0, strings, left, temp.length);
    }

    private void merge(int[] integers, int left, int middle, int right) {
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
