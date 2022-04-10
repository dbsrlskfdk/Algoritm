import java.util.Arrays;
import java.util.Scanner;

public class Quick_Sort {
    static void quick_sort(int[] A, int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quick_sort(A, p, q - 1); // partition 안에서 가장 마지막에 있던 원소와 비교해서 경계가 나눠지고, q값으로 가장 마지막인 원소보다 작은 부분을 또 정렬해준다.
            quick_sort(A, q+1, r); // 가장 마지막인 원소보다 큰부분을 정렬해준다.
        }
    }
    static int partition(int[] A, int p, int r){
        int x = A[r]; // 끝부분의 값을 비교해줄 값으로 정해둔다.
        int i = p-1; // 위의 x와 비교해서 더 작은 값이 들어갈 인덱스
        for (int j = p; j <= r-1; j++) { // 나눠진 부분의 시작 부분부터 끝 부분인덱스 이전까지 => j는 x보다 큰 배열이 올 부분의 시작 인덱스로 사용될 것
            if(A[j] <= x){ // 해당하는 부분의 값이 비교하려는 부분과 비교해서 더 작다면
                int tmp = A[j];
                A[j] = A[++i];
                A[i] = tmp; // x보다 작은 부분이 담길 인덱스였던 i를 하나 늘려주고, 해당 값과 증가된 인덱스(i)부분과 교환하여, x보다 작은부분으로옮겨준다.

            }
        }
        int tmp = A[r];
        A[r] = A[i+1];
        A[i+1] = tmp;// 마지막은 비교하는 값으로 쓰였던 마지막의 값과, x보다 작은 인덱스 부분이었던 곳 다음에 x를 넣어주고 교환.
       return i+1; // x와 비교해서 작은 인덱스 부분의 다음 인덱스를 전달
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            A[i] = Integer.parseInt(sc.next());
        }
        System.out.println("Before Sorted");
        System.out.println(Arrays.toString(A));
        quick_sort(A, 0, A.length-1);
        System.out.println("After Sorted");
        System.out.println(Arrays.toString(A));

    }
}
