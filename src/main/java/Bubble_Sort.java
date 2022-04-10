import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Bubble_Sort {
    static void bubble_sort(int[] A, int n){
        for (int last = n; last > 0 ; last--) { // 똑같이 배열의 끝부분은 변경된 가장 큰 값이 위치하기 때문에, 범위를 점점 좁혀나가며 수행
            boolean sorted = java.lang.Boolean.TRUE; // 변경이 이루어졌는지를 판단하기 위한, sentinel value -> 알고리즘의 수행시간을 줄일 수 있다.
            for (int i = 0; i < last-1; i++) { // 마지막값 전까지 반복 수행
                int tmp = A[i+1];
                if (A[i] > A[i+1]){ // 만약 자신의 값이, 내 옆의 값보다 크다면, 서로 자리를 바꿔준다.
                    A[i+1] = A[i];
                    A[i] = tmp;
                    sorted = java.lang.Boolean.FALSE; // 변경이 이루어졌음을 체크하기 위해서, False 로 변경
                }
            }
            if (sorted == java.lang.Boolean.TRUE){ // 만약 변경이 이루어지지않았다면, 정렬이 완료되었다는 것으로 생각할 수 있으므로 정렬 종료.
                return;
            }
        }
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

        bubble_sort(A, A.length);
        System.out.println("After Sorted");
        System.out.println(Arrays.toString(A));
    }
}
