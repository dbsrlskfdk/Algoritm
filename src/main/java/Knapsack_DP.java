import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Knapsack_DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];

        ArrayList<Integer[]> A = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A.add(new Integer[]{W, V});
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if(j - A.get(i-1)[0] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - A.get(i-1)[0]] + A.get(i-1)[1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-1][K]);
    }
}