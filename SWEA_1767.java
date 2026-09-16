import java.util.*;
import java.io.*;

public class SWEA_1767 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<int[]> coreIdx = new ArrayList<>();
    static int[][] fild;
    static int N, maxCore, minWire, initialCoreCount;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int testcases = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testcases; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            fild = new int[N][N];
            coreIdx.clear();
            maxCore = 0;
            minWire = Integer.MAX_VALUE;
            initialCoreCount = 0;

            putVal();

            dfs(0, initialCoreCount, 0);

            sb.append("#").append(tc).append(" ").append(minWire).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int index, int coreCount, int wireLength) {

        if (coreCount + (coreIdx.size() - index) < maxCore) {
            return;
        }

        if (index == coreIdx.size()) {
            if (coreCount > maxCore) {
                maxCore = coreCount;
                minWire = wireLength;
            } else if (coreCount == maxCore) {
                minWire = Math.min(minWire, wireLength);
            }
            return;
        }

        int[] curr = coreIdx.get(index);
        int r = curr[0];
        int c = curr[1];

        for (int d = 0; d < 4; d++) {
            if (canConnect(r, c, d)) {
                int length = setWire(r, c, d, 2);
                dfs(index + 1, coreCount + 1, wireLength + length);
                setWire(r, c, d, 0);
            }
        }

        dfs(index + 1, coreCount, wireLength);
    }

    public static boolean canConnect(int r, int c, int d) {
        int nx = r + dx[d];
        int ny = c + dy[d];

        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if (fild[nx][ny] != 0) return false;
            nx += dx[d];
            ny += dy[d];
        }
        return true;
    }

    public static int setWire(int r, int c, int d, int type) {
        int length = 0;
        int nx = r + dx[d];
        int ny = c + dy[d];

        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            fild[nx][ny] = type;
            length++;
            nx += dx[d];
            ny += dy[d];
        }
        return length;
    }

    public static void putVal() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                fild[i][j] = Integer.parseInt(st.nextToken());
                if (fild[i][j] == 1) {

                    if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                        initialCoreCount++;
                        continue;
                    }
                    coreIdx.add(new int[] {i, j});
                }
            }
        }
    }
}