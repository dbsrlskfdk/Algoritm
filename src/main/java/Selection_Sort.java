import java.util.Arrays;


public class Selection_Sort {
    public static void selection_sort(int[] A, int n){
        for (int last = n-1; last > 0; last--) { // last는 인덱스, n은 배열의 크기를 의미 , last = n-1 을 통해서 인덱스 값으로 -> last가 > 0 이면 last값을 감소 => 체크할 값의 마지막을 점점 줄여나간다.
            int k = Largest_idx(A, last); // 배열A에서 last인덱스까지 가장 큰값의 index를 반환하는 함수
            int tmp = A[last];
            A[last] = A[k];
            A[k] = tmp;
        }
    }
    static int Largest_idx(int[] A, int last){
        int largest = 0;
        for (int i = 0; i <= last; i++) { //
            if (A[i] > A[largest]){
                largest = i;
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int A[] = {8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
        System.out.println(Arrays.toString(A));
        selection_sort(A, A.length);
        System.out.println(Arrays.toString(A));
    }
}
