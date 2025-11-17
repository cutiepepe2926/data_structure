//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40
        };

        int result = binarySearch(arr, 44);
        System.out.println(result);
    }

    public static int binarySearch(int[] list, int a) {
        int front = 0;
        int end = list.length-1;

        while (front<=end) {
            int mid = ( front + end ) / 2;

            if (list[mid]==a) {
                return mid;
            }
            else if (list[mid]<a) {
                front = mid+1;
            }
            else {
                end = mid-1;
            }

        }
        return -1;
    }
}