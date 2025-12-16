package Sort;

import java.util.*;
// 단순 bubbleSort
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8, 0, 3};
        int[] arr2 = {5, 1, 4, 2, 8, 0, 3};
        bubbleSortStartFromEnd(arr1);
        bubbleSortStartFromFront(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


    // 단순한 위치 swap 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 시작을 뒤에서부터 시작하는 버블정렬
    public static void bubbleSortStartFromEnd(int[] arr) {
        // n-2개까지만 동작 - > n-2까지만해도 swap 때문에 n-1까지 동작 가능함
        for (int i = 0; i < arr.length - 1; i++) {
            // 뒤에서 앞으로 이동하기 때문에, n-1부터 시작하되, j는 i 전까지만 움직임. 
            // i 앞으로는 이미 정렬이 된 상태를 의미함
            for (int j = arr.length - 1; j > i; j--) {
                //ascending
//                if (arr[j - 1] > arr[j]) {
//                    swap(arr, j, j - 1);
//                }
                //descending
                if (arr[j - 1] < arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    // 시작을 앞에서부터 시작하는 버블정렬
    public static void bubbleSortStartFromFront(int[] arr) {
        // n-2개 까지만 동작 -> n-2까지만해도 swap 때문에 n-1까지 동작 가능함
        for (int i = 0; i < arr.length - 1; i++) {
            // 앞에서 뒤로 이동하기 때문에, 0부터 시작하되, j는 n-1-i 전까지만 움직임. 
            // i 뒤로는 이미 정렬이 된 상태를 의미함
            for (int j = 0; j < arr.length - 1 - i; j++ ) {
                //ascending
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1);
//                }
                //descending
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
