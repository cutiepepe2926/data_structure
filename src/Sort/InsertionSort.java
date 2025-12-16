package Sort;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8, 0, 3};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

     public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j;
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
     }

}
