import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Knapsack {
    static int knapsack(int i, int W, ArrayList<Integer[]> A, int indent) {
        if (i < 0){
            String inde = "\t".repeat(indent);
            System.out.println(inde+"Knapsack["+i +","+W+"]");
            return 0;
        }
        if (A.get(i)[0] > W){
            String inde = "\t".repeat(indent);
            System.out.println(inde+"Knapsack["+i +","+W+"]");
            System.out.println(inde+"W : "+ W + ", " + "Weight : "+A.get(i)[0]);
            return knapsack(i-1, W, A, indent+1);
        }else{
            String inde = "\t".repeat(indent);
            System.out.println(inde+"Knapsack["+i +","+W+"]");
            System.out.println(inde+"W : "+ W + ", " + "Weight : "+A.get(i)[0]);
            return Math.max(knapsack(i - 1, W, A, indent+1), knapsack(i - 1, W - A.get(i)[0], A,indent+1) + A.get(i)[1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int indent = 0;

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

        System.out.println(knapsack(N-1, K, A, indent));
    }


}
