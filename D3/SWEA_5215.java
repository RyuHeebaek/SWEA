import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_5215{

    static int n, k;
    static int[] cal;
    static int[] score;
    static int maxScore;

    static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCases; i++){
            st = new StringTokenizer(br.readLine());
            //재료 개수
            n = Integer.parseInt(st.nextToken());
            //최대칼로리
            k = Integer.parseInt(st.nextToken());

            score = new int[n];
            cal = new int[n];

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                score[j] = Integer.parseInt(st.nextToken());
                cal[j] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;

            dfs(0,0,0);

            System.out.println("#" + (i + 1) + " " + maxScore);
        }
    }

    static void dfs(int idx, int sumScore, int sumKal){
        if(sumKal > k) return;

        if (idx == n) {
            maxScore = Math.max(maxScore, sumScore);
            return;
        }
        dfs(idx + 1, sumScore, sumKal);

        dfs(idx + 1, sumScore + score[idx], sumKal +  cal[idx]);
    }
}