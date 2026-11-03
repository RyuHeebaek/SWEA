import java.util.*;
import java.io.*;

public class SWEA_2477 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] arr;

    public static void main(String[] args) throws IOException{

        for(int i = 1; i <= 10; i++) {

            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            putVal(N);

            sb.append("#").append(i).append(" ").append(check(N)).append("\n");
        }
        System.out.println(sb);
    }

    public static void putVal(int N) throws IOException{
        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
    }

    public static int check(int N) {

        int count = 0;
        boolean flag = false;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[j][i] == 1) {
                    flag = true;
                }
                if(arr[j][i] == 2 && flag) {
                    flag = false;
                    count++;
                }
            }
            flag = false;
        }
        return count;
    }

}
