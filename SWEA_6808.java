import java.io.*;
import java.util.*;

class SWEA_6808 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int testCases;
    static boolean[] numCheck, visited;
    static int[] arr, resultArr;
    static int[] possibleNums;
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {

        testCases = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testCases; i++) {

            putVal();


            winCount = 0;
            loseCount = 0;
            visited = new boolean[9];
            resultArr = new int[9];
            dfs(0);

            sb.append("#").append(i).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.println(sb);
    }

    public static void putVal() throws IOException{
        st = new StringTokenizer(br.readLine());
        arr = new int[9];
        numCheck = new boolean[19];
        possibleNums = new int[9];

        int idx = 0;

        for(int i = 0; i < 9; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            numCheck[num] = true;
        }

        for(int i = 1; i < 19; i++){
            if(!numCheck[i]) {
                possibleNums[idx++] = i;
            }
        }
    }

    public static void dfs(int depth) {

        if(depth == 9) {
            int winScore = 0;
            int loseScore = 0;

            for(int i = 0; i < 9; i++){
                if(arr[i] > resultArr[i]) {
                    winScore += arr[i] + resultArr[i];
                } else if(arr[i] < resultArr[i]) {
                    loseScore += arr[i] + resultArr[i];
                }
            }

            if(winScore > loseScore) {
                winCount++;
            } else if (winScore < loseScore) {
                loseCount++;
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                resultArr[depth] = possibleNums[i];

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}