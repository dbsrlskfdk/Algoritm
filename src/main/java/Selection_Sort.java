import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Selection_Sort {
    public static void selection_sort(int[] A, int n){
        for (int last = n-1; last > 0; last--) { // last는 인덱스, n은 배열의 크기를 의미 , last = n-1 을 통해서 인덱스 값으로 -> last가 > 0 이면 last값을 감소 => 체크할 값의 마지막을 점점 줄여나간다.
            int k = Largest_idx(A, last); // 배열A에서 last인덱스까지 가장 큰값의 index를 반환하는 함수
            int tmp = A[last];
            A[last] = A[k];
            A[k] = tmp;
            // 체크할 마지막 값이 위치하는 곳으로, 제일 큰값과 자리를 변경해줘서 제일큰값을 계속 뒤로 보내면서, 탐색범위를 줄여나가며 수행
        }
    }
    static int Largest_idx(int[] A, int last){
        int largest = 0;
        for (int i = 0; i <= last; i++) {
            if (A[i] > A[largest]){ // 배열에서 체크할 마지막 값 사이에, 더 큰 값이 있다면
                largest = i; // 더 큰값의 인덱스로 largest 인덱스를 변경
            }
        }
        return largest;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] A = new int[10];
        for (int i = 0; i < 10; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Before Sorted");
        System.out.println(Arrays.toString(A));

        System.out.println("After Sorted");
        selection_sort(A, A.length);
        System.out.println(Arrays.toString(A));
    }
}
