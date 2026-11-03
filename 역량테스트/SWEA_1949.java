import java.io.*;
import java.util.*;

public class SWEA_1949 {

    public static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int T, N, K, MAX_VALUE, result;
    static int[][] field;
    static boolean[][] visited;
    static List<Node> startNode = new ArrayList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            initialize();
            for(Node n : startNode) {
                int x = n.x;
                int y = n.y;
                visited[x][y] = true;
                dfs(x, y, field[x][y], 1, false);
                visited[x][y] = false;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean canMove(int x, int y) {
        return inRange(x, y) && !visited[x][y];
    }

    public static void dfs(int x, int y, int height, int moveCount, boolean usedChance) {

        result = Math.max(result, moveCount);

        if (moveCount + (N * N - moveCount) <= result) return;

        if (usedChance && moveCount + height - 1 <= result) {
            return;
        }



        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!canMove(nx, ny)) continue;

            if(field[nx][ny] < height) {
                visited[nx][ny] = true;
                dfs(nx, ny, field[nx][ny], moveCount + 1, usedChance);
                visited[nx][ny] = false;
            } else if(!usedChance) {
                if(field[nx][ny] - K < height) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, height - 1, moveCount + 1, true);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void initialize() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        field = new int[N][N];
        visited = new boolean[N][N];
        MAX_VALUE = result = 0;
        startNode.clear();
        getValue();
    }

    public static void getValue() throws IOException{
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                MAX_VALUE = Math.max(MAX_VALUE, field[i][j]);
            }
        }
        getStartNode();
    }

    public static void getStartNode() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(field[i][j] == MAX_VALUE) startNode.add(new Node(i, j));
            }
        }
    }
}
