import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 8, 4, 9, 1, 6, 2, 7};
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    // 분할(재귀)가 포함된 퀵 정렬
    public static void quickSort(int[] arr, int left, int right) {

        if (right - left < 2) {           // 원소가 0~2개 구간
            if (left < right && arr[left] > arr[right]) swap(arr, left, right);
            return;
        }


        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int m = sort3elem(arr, pl, (pl+pr)/2, pr);
        // 처음, 가운데, 끝 요소를 정렬한 후 가운데 값 저장

        int pivot = arr[m]; // 피벗

        // 가운데 요소와 끝에서 두 번째 요소(right - 1)을 교환
        swap(arr, m, right - 1);
        pl++; // 왼쪽 커서를 오른쪽으로 1만큼 진행
        pr -= 2; // 오른쪽 커서를 왼쪽으로 2만큼 진행

        do {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl ,right);


    }

    // arr[a], arr[b], arr[c] 3개의 요소에 대한 정렬 수행
    public static int sort3elem(int[] arr, int a, int b, int c) {
        if (arr[a] > arr[b]) swap(arr, a, b);
        if (arr[b] > arr[c]) swap(arr, b, c);
        if (arr[a] > arr[b]) swap(arr, a, b);
        return b; // 이제 arr[b]가 중앙값(피벗으로 쓰기 좋음)
    }

    // idx1과 idx2 스왑
    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
