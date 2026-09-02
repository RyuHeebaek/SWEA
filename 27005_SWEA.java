import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class SWEA_27005{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int MAX_LEN = 1000;
    static int[] A = new int[MAX_LEN + 1];

    public static void main(String[] args) throws IOException {

        precalculate();

        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(A[n]).append("\n");
        }

        System.out.println(sb);
    }

    static void precalculate() {
        A[0] = 1; A[1] = 1;

        for(int i = 2; i <= MAX_LEN; i++){
            Set<Integer> forbiddenVal = new HashSet<>();

            for(int k = 1; k <= i / 2; k++){

                int forbidden = 2 * A[i - k] - A[i - 2 * k];
                forbiddenVal.add(forbidden);

            }

            int forbiddenNum = 1;
            while(forbiddenVal.contains(forbiddenNum)){
                forbiddenNum++;
            }
            A[i] = forbiddenNum;
        }
    }

}