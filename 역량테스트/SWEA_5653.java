import java.io.*;
import java.util.*;

public class SWEA_5653 {

    public static class cell{
        int x;
        int y;
        int activeTime;
        public cell(int x, int y, int activeTime) {
            this.x = x;
            this.y = y;
            this.activeTime = activeTime;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int T, N, M, K;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] cellState;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            initialize();
            sb.append("#").append(t).append(" ").append(getResult()).append("\n");
        }
        System.out.println(sb);
    }

    public static void initialize() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cellState = new int[700][700];
    }

    public static void getCells() throws IOException{
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                cellState[i+300][j+300] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int getResult() {
        return 0;
    }
}
