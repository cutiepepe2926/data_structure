import static java.util.Arrays.deepToString;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {

        Random rnd = new Random(42); // 시드 고정(재현 가능). 원하면 제거/변경 가능
        Set<Integer> set = new LinkedHashSet<>();

        while (set.size() < 100) {
            set.add(1 + rnd.nextInt(500)); // 1~500
        }

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Array before sorting" + Arrays.toString(arr));
        bubblesort(arr, arr.length);
        System.out.println("Array after sorting" + Arrays.toString(arr));

    }

    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

//    public static void bubblesort(int[] arr,int n) {
//        for (int i = 0; i < n-1; i++) {
//            for (int j = n-1; j > i; j--) {
//                if (arr[j-1] > arr[j]) {
//                    swap(arr, j-1, j);
//                }
//            }
//        }
//    }


    public static void bubblesort(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-1-i; j++) {

                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }

            }

        }
    }
}
