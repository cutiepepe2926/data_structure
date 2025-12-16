package Sort;

import java.io.*;

class QuickSort3 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length-1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void threeSort(int[] arr, int front, int mid, int end) {
        if (arr[front] > arr[mid]) swap(arr, front, mid);
        if (arr[mid] > arr[end]) swap(arr, mid, end);
        if (arr[front] > arr[mid]) swap(arr, front, mid);
    }

    public static void quickSort(int[] arr, int front, int end) {
        int mid = (front+end)/2;
        threeSort(arr, front, mid, end);

        if (end - front + 1 > 3) {
            int pivot = arr[mid];
            swap(arr, mid, end-1);
            int pl = front;
            int pr = end - 1;

            while (true) {
                do {pl++;} while ( arr[pl] < pivot && pl < end);
                do {pr--;} while (arr[pr] > pivot && front < pr);
                if (pl >= pr) break;
                swap(arr, pl, pr);
            }

            swap(arr, pl, end-1);
            quickSort(arr, front, pl-1);
            quickSort(arr, pl+1, end);

        }
    }
}
