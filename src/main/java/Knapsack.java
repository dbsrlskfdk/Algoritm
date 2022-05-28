import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Knapsack {
    static int knapsack(int i, int W, ArrayList<Integer[]> A) {
        if (i < 0){
            return 0;
        }
        if (A.get(i)[0] > W){
            return knapsack(i-1, W, A);
        }else{
            return Math.max(knapsack(i - 1, W, A), knapsack(i - 1, W - A.get(i)[0], A) + A.get(i)[1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer[]> A = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A.add(new Integer[]{W, V});
        }

/*        for (int i = 0; i < N; i++) {
            System.out.println("i : "+i +", W : "+A.get(i)[0]+", V : "+A.get(i)[1]);
        }*/

        System.out.println(knapsack(N-1, K, A));
    }


}
