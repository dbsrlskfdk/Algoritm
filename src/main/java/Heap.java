import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heap {
    /*
    전달해주는 배열 A의 크기를 N 이라고 한다면, N-1로 넘겨줘야한다.
    배열 A = {0, ~~} 맨앞에 0을 채워서 인덱스를 하나씩 늘려주고, 판단하게 하는 것이 쉬움.
     */
    int N;
    ArrayList<Integer> A;
    Heap(ArrayList<Integer> A, int N){
        this.N = N;
        this.A = A;
        for (int i = N/2; i > 0 ; i--) {
            heapify(A, i, this.N); // 이진 배열을 받았을 때, 이것을 힙으로 만들어주는 작업을 바로 수행
        }
    }
    void heap_show(){
        for (int i = 1; i <= N/2  ; i++) {
            System.out.println("i = " + i + " , A[i] : " + A.get(i));
            if (2 * i <= N){
                System.out.println("left : "+ A.get(2 * i));
            }
            if (2 * i + 1 <= N) {
                System.out.println("right : " + A.get(2 * i + 1));
            }

        }
    }
    void heapify(ArrayList<Integer> A, int k, int N){ // heap 성질을 만족하도록, 수정
        int left = 2*k;
        int right = 2*k + 1;
        int smaller;

        if (right <= N){ // right이 더 뒤쪽이기에, right이 존재한다면 먼저 체크
            if (A.get(left) < A.get(right)){ // left 값이 right 값보다 작다면
                smaller = left; // 더 작은 자식 노드는 left
            }else{
                smaller = right; // 아니면 right
            }
        }else if(left <= N){ // right값이 없고, left값까지만 존재한다면
            smaller = left; // 작은 자식 노드는 그냥 left
        }else   {
            return; // 둘 다 해당 안되면, leaf node(자식 노드가 없는 노드 , 말단 노드)라고 이해할 수 있다.
        }

        if (A.get(smaller) < A.get(k)){ // 만약 위에서 찾은 자식 노드 중 작은 노드가 , 그의 루트노드보다 작다면, heap 성질을 만족하지 않는 것이니까 만족하도록 교환해줘야함
            Collections.swap(A, smaller, k); // 루트 노드랑 작았던 자식 노드랑 swap
            heapify(A, smaller, N); // 재귀적으로 수행.
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0)); // A 배열 맨 앞에 0을 추가해줌으로써, 뒤의 실제값들의 인덱스를 1씩 늘려줌.

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }
        Heap heap = new Heap(A, A.size() - 1); // 파라미터 넘겨줄 떄, 실제 A 사이즈 에서 한개 뺀(인덱스를 늘려주기 위해 사용된 0) 값을 넘겨주기.
        heap.heap_show();
    }
}


