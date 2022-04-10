import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Insertion_sort {
    static void insertion_sort(int[] A, int n){
        for (int i = 1; i < n ; i++) { // 관찰할 부분을 점점 늘려가는 정렬.
            int loc = i-1; //초기에는 관찰할 배열의 마지막의 이전 부분 -> 이동하게되는 변수
            int newItem = A[i]; //관찰할 부분의 다음의 숫자 -> 자리를 찾아가야할 수

            while(loc >= 0 && newItem < A[loc]){ // 관찰할 부분이 맨 처음이 아니고, 자리를 찾아가야할 수가 비교를 해야할 움직이는 부분의 수보다 크다면 수행
                A[loc + 1] = A[loc]; // 해당부분부터 뒤로 한칸씩 수를 밀어준다.
                loc--; // 관찰할 부분 인덱스 한개 감소
            }
            A[loc + 1] = newItem; // 위의 while문을 탈출했다는 것은, 자리를 찾아가야할 수가 위치 할 자리라는 것 -> 해당 부분에 수를 대입
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
        insertion_sort(A, A.length);

        System.out.println("After Sorted");
        System.out.println(Arrays.toString(A));
    }


}
