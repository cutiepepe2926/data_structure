import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr1 = {
                187, 42, 399, 5, 276, 91, 453, 128, 310, 67,
                220, 14, 488, 173, 59, 361, 240, 7, 415, 102,
                334, 26, 470, 155, 80, 298, 11, 392, 205, 49,
                441, 120, 263, 33, 478, 166, 73, 319, 95, 231,
                12, 389, 214, 60, 452, 141, 287, 19, 406, 110,
                345, 28, 497, 158, 84, 301, 9, 374, 201, 53,
                430, 124, 255, 37, 466, 171, 76, 322, 99, 236,
                16, 381, 209, 63, 447, 135, 290, 23, 411, 115,
                356, 31, 490, 162, 88, 307, 3, 368, 198, 57,
                425, 129, 272, 40, 459, 180, 70, 333, 104, 242
        };

        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    // 분할(재귀)가 포함된 퀵 정렬
    public static void quickSort(int[] arr, int front, int end) {
        int mid = (front + end)/2;
        threeSort(arr, front, mid, end);

        if (end - front + 1 > 3) {
            int pivot = arr[mid];
            swap(arr,mid,end-1);
            int pl = front;
            int pr = end-1;

            while(true) {
                while(arr[++pl] < pivot && pl < end);
                while(arr[--pr] > pivot && front < pr);
                if (pl>=pr) break;
                swap(arr,pl,pr);
            }

            swap(arr, pl, end-1);
            quickSort(arr, front, pl-1);
            quickSort(arr, pl+1, end);

        }

    }

    // arr[a], arr[b], arr[c] 3개의 요소에 대한 정렬 수행
    public static void threeSort(int[] arr, int front, int mid, int end) {
        if (arr[front] > arr[mid]) swap(arr, front, mid);
        if (arr[mid] > arr[end]) swap(arr, mid, end);
        if (arr[front] > arr[mid]) swap(arr, front, mid);
        // 이제 arr[b]가 중앙값(피벗으로 쓰기 좋음)
    }

    // idx1과 idx2 스왑
    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
