package Sort;

import java.util.*;
// 2차 개선 bubbleSort -> 정렬된 부분 건너뛰기
public class BubbleSort3 {
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
        int k = 0; // 정렬이 완료된 곳의 인덱스를 나타낼 변수
        int n = arr.length;

        while (k < n - 1) { // k가 n-1전까지 반복 = 전부 다 정렬되기 전 까지 반복
            int last = n - 1; // 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
                    last = j; // 요소를 교환한 곳이 정렬이 안된 지점
                }
            }
            k = last; //정렬이 안된 지점까지만 확인하면 나머지 시간을 단축 가능
        }
    }

    public static void bubbleSortStartFromFront(int[] arr) {
        int n = arr.length;
        int k = n - 1; // 오른쪽 경계(여기까지 검사)

        while (k > 0) {
            int last = 0; // 이번 패스에서 "마지막 swap 위치" (swap 없으면 0 유지)
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    last = j; // 마지막 swap 발생 위치 기록
                }
            }
            k = last;
        }
    }
}
