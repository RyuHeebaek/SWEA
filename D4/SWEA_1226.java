import java.io.*;
import java.util.*;

public class SWEA_1226 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Boolean flag;
    static int startIdxOfX;
    static int startIdxOfY;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        for(int i = 1; i <= 10; i++) {
            br.readLine();

            arr = new int[16][16];

            startIdxOfX = -1;
            startIdxOfY = -1;
            flag = false;

            putVal();

            dfs(startIdxOfX, startIdxOfY);

            sb.append("#").append(i).append(" ").append(flag ? 1 : 0).append("\n");

        }
            System.out.print(sb);
    }

    public static void putVal() throws IOException {

        for(int i = 0; i < 16; i++){

            String str = br.readLine();

            for(int j = 0; j < 16; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));

                if(arr[i][j] == 2){
                    startIdxOfX = i;
                    startIdxOfY = j;
                }
            }

        }


    }

    public static void dfs(int x, int y) {

        if(arr[x][y] == 1) return;

        if(arr[x][y] == 3) {flag = true; return;}

        arr[x][y] = 1;


        for(int move = 0; move < 4; move++) {
            int mx = x + dx[move];
            int my = y + dy[move];

            if (mx >= 0 && my >= 0 && mx < 16 && my < 16 && arr[mx][my] != 1) {
                dfs(mx, my);
            }
        }

    }
}
