import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Merge_Sort {
    static void merge_sort(int[] A, int p, int r){
        if (p < r) {
            int q = (p + r) / 2; // 중간부분을 찾고
            merge_sort(A, p, q); // 처음부분부터 중간부분 배열
            merge_sort(A, q + 1, r); // 중간부분부터 마지막 부분까지 배열 시킨다.
            merge(A, p, q, r); // 합병을 하면서, 정렬해줌
        }
    }
    static void merge(int[] A, int p, int q, int r){
        int i = p; // 나눠진 부분의 전기 시작 인덱스
        int j = q + 1; // 중간부분 이후 인덱스 -> 나눠진 인덱스들 중 후기 배열 시작부분
        int t = 0; // 임시배열에 합병을 하면서 값 비교를 통해 대입을 시켜주기 위한 변수

        int[] tmp = new int[A.length]; // 정렬을 시켜줄 배열의 크기와 동일한 임시배열을 만들어주고

        while (i <= q && j <= r) { // 만약 앞쪽 배열이 끝나지않았고, 뒤쪽 배열도 끝나지않았다면
            if(A[i] < A[j]){ // 뒤쪽 배열에서 인덱스 부분의 값보다, 앞쪽 배열에서 인덱스 부분의 값이 더 크다면
                tmp[t++] = A[i++]; // 임시 배열에 앞쪽 배열 즉, 더 작은 값을 대입 해주고, 앞쪽 배열 인덱스 하나 증가 / 임시 배열 인덱스 하나 증가
            }else{
                tmp[t++] = A[j++]; // 임시 배열에 뒤쪽 배열 즉, 더 작은 값을 대입 해주고, 뒤쪽 배열 인덱스 하나 증가 / 임시 배열 인덱스 하나 증가
            }
        }
        while(i <= q){ // 만약 위의 과정처럼 나눠진 양쪽 배열을 합병을 시작하며 대입을 했는데도, 전기 배열을 탐색을 마치지 못했다면
            tmp[t++] = A[i++]; // 전기 배열을 임시 배열에 다 넣어준다.
        }
        while (j <= r) { // 후기 배열을 마치지 못했을 경우도 똑같이 탐색을 마치지 못했다면
            tmp[t++] = A[j++]; // 후기 배열을 임시 배열에 다 넣어준다.
        }

        for (int idx = p; idx < t; idx++) { // 임시 배열에 정렬해놓은 값들을 실제의 배열에 다시 옮겨준다.
            A[idx] = tmp[idx];
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
        merge_sort(A, 0, A.length-1);
        System.out.println("After Sorted");
        System.out.println(Arrays.toString(A));
        br.close();
    }
}
