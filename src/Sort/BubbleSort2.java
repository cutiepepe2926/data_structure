package Sort;

import java.util.*;
// 1차 개선 bubbleSort -> 정렬된 경우 바로 stop
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8, 0, 3};
        int[] arr2 = {5, 1, 4, 2, 8, 0, 3};
        bubbleSortStartFromEnd(arr1);
        bubbleSortStartFromFront(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSortStartFromEnd(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            
            int exchg = 0; // 이번 패스에서 swap 횟수
            
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
            
            // 이번 패스에서 swap 0이다 -> 이미 정렬되었다로 판단해 for문 종료
            if (exchg==0) break;
        }
    }

    public static void bubbleSortStartFromFront(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int exchg = 0; // 이번 패스에서 swap 횟수

            for (int j = 0; j < arr.length - 1 - i; j++ ) {
                //ascending
//                if (arr[j] > arr[j + 1]) {
//                    swap(arr, j, j + 1);
//                }
                //descending
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

                // 이번 패스에서 swap 0이다 -> 이미 정렬되었다로 판단해 for문 종료
                if (exchg==0) break;
            }
        }
    }


}
