import java.io.*;
import java.util.*;

class SWEA_1767 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static int N, maxCore, minWire;
    static List<int[]> cores;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine().trim());

        for(int t = 1; t <= testCase; t++) {

            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            cores = new ArrayList<>();

            putValues();

            maxCore = 0;
            minWire = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + minWire);
        }

    }

    public static void putValues() throws IOException {
        for(int i = 0 ; i < N; i++) {

            st = new StringTokenizer(br.readLine().trim());

            for(int j = 0 ; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    if(i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
                    cores.add(new int[] {i, j});

                }
            }
        }
    }

    static void dfs(int idx, int coreCount, int wireLength) {
        if(coreCount + (cores.size() - idx) < maxCore) return;

        if(idx == cores.size()) {
            if(coreCount > maxCore) {
                maxCore = coreCount;
                minWire = wireLength;
            } else if(coreCount == maxCore) {
                minWire = Math.min(minWire, wireLength);
            }
            return;
        }

        int[] current = cores.get(idx);
        int x = current[0];
        int y = current[1];

        for(int d = 0; d < 4; d++) {
            int len = getWireLength(x, y, d);

            if(len > 0) {
                setStatus(x, y, d, 2);
                dfs(idx+1, coreCount+1, wireLength + len);
                setStatus(x, y, d, 0);
            }
        }
        dfs(idx + 1, coreCount, wireLength);
    }

    static int getWireLength(int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        int count = 0;

        while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if(map[nx][ny] != 0) return 0;
            count++;
            nx += dx[d];
            ny += dy[d];
        }
        return count;
    }

    static void setStatus(int x, int y, int d, int status) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        while(nx >= 0 && ny >= 0 && nx < N && ny < N) {
            map[nx][ny] = status;
            nx += dx[d];
            ny += dy[d];
        }
    }
}