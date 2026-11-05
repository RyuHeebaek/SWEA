import java.io.*;
import java.util.*;

public class SWEA_5656 {

    public static class Node {
        int x, y, energy;
        public Node(int x, int y, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, W, H, minBricks;
    static int[][] field;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        while (line == null || line.trim().isEmpty()) {
            line = br.readLine();
        }
        T = Integer.parseInt(line.trim());

        for (int t = 1; t <= T; t++) {
            initialize();
            sb.append("#").append(t).append(" ").append(result()).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int depth, int[][] currentMap) {
        int currentCount = countBricks(currentMap);
        if (currentCount == 0) {
            minBricks = 0;
            return;
        }

        if (depth == N) {
            minBricks = Math.min(minBricks, currentCount);
            return;
        }

        boolean anyHit = false;
        for (int col = 0; col < W; col++) {
            int topRow = -1;
            for (int r = 0; r < H; r++) {
                if (currentMap[r][col] != 0) {
                    topRow = r;
                    break;
                }
            }

            if (topRow == -1) continue;

            anyHit = true;
            int[][] nextMap = copyMap(currentMap);
            boom(topRow, col, nextMap);
            gravity(nextMap);
            dfs(depth + 1, nextMap);

            if (minBricks == 0) return;
        }

        if (!anyHit) {
            minBricks = 0;
        }
    }

    public static void boom(int startR, int startC, int[][] map) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startR, startC, map[startR][startC]));
        map[startR][startC] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int power = curr.energy;

            if (power == 1) continue;

            for (int d = 0; d < 4; d++) {
                for (int p = 1; p < power; p++) {
                    int nx = curr.x + dx[d] * p;
                    int ny = curr.y + dy[d] * p;

                    if (!inRange(nx, ny)) break;
                    if (map[nx][ny] == 0) continue;

                    if (map[nx][ny] > 1) {
                        queue.add(new Node(nx, ny, map[nx][ny]));
                    }
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void gravity(int[][] map) {
        for (int j = 0; j < W; j++) {
            int writeIdx = H - 1;
            for (int i = H - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    int val = map[i][j];
                    map[i][j] = 0;
                    map[writeIdx--][j] = val;
                }
            }
        }
    }

    public static int countBricks(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) count++;
            }
        }
        return count;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    public static int[][] copyMap(int[][] src) {
        int[][] dest = new int[H][W];
        for (int i = 0; i < H; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, W);
        }
        return dest;
    }

    public static void initialize() throws IOException {
        String line = br.readLine();
        while (line == null || line.trim().isEmpty()) {
            line = br.readLine();
        }
        line = line.replace('\u00A0', ' ');
        st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        field = new int[H][W];
        getInput();
    }

    public static void getInput() throws IOException {
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            while (line == null || line.trim().isEmpty()) {
                line = br.readLine();
            }
            line = line.replace('\u00A0', ' ');
            st = new StringTokenizer(line);
            for (int j = 0; j < W; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int result() {
        minBricks = Integer.MAX_VALUE;
        dfs(0, field);
        return minBricks;
    }
}