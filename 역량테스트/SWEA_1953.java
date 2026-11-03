import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA_1953 {

    public static class Node{
        int x;
        int y;
        int moveCount;
        public Node(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

    static int T, N, M, R, C, L, totalCount;
    // 1: 상, 2: 하, 3: 좌, 4: 우
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int[] OPPOSITE = {1, 0, 3, 2};
    static final int[][] PIPE_DIRS = {
        {},
        {0, 1, 2, 3},
        {0, 1},
        {2, 3},
        {0, 3},
        {1, 3},
        {1, 2},
        {0, 2}
    };
    
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            totalCount = 1;
            field = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    field[i][j] =  Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            bw.write("#" + t + " " + totalCount + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean isConnected(int nextType, int oppDir) {
        for(int d : PIPE_DIRS[nextType]) {
            if(d == oppDir) return true;
        }
        return false;
    }

    public static int[] getDir(int x, int y) {
        return PIPE_DIRS[field[x][y]];
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static boolean canMove(int x, int y) {
        return inRange(x, y) && !visited[x][y] && field[x][y] != 0;
    }

    public static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(R, C, 1));
        visited[R][C] = true;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.moveCount == L) {
                continue;
            }
            
            for(int d : getDir(curr.x, curr.y)) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(canMove(nx, ny) && isConnected(field[nx][ny], OPPOSITE[d])) {
                    visited[nx][ny] = true;
                    totalCount++;
                    queue.add(new Node(nx, ny, curr.moveCount + 1));
                }
            }
            
        }
    }
}
