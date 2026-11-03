import java.io.*;
import java.util.*;

public class SWEA_2105 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int T, N, startX, startY, result;
    static int[][] field;
    static boolean[][] visited;
    static boolean[] nums;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void getVal() throws IOException{
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            field = new int[N][N];
            visited = new boolean[N][N];
            nums = new boolean[101];
            result = -1;
            getVal();
            LOOP:for(int i = 0; i < N-2; i++) {
                for(int j = 1; j < N-1; j++) {
                    int maxPossible = 2 * (Math.min(N - 1 - i, N - 1 - j) + Math.min(N - 1 - i, j));
                    if (maxPossible <= result) continue;
                    startX = i; startY = j;
                    visited[i][j] = true;
                    nums[field[i][j]] = true;
                    dfs(i, j, 0, 0);
                    visited[i][j] = false;
                    nums[field[i][j]] = false;
                    if(result == 2*(N-1))break LOOP;
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y, int moveCount, int direction) {

        for(int i = direction; i <= direction + 1; i++) {
            if(i >= 4) break;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == startX && ny == startY && moveCount >= 3) {
                result = Math.max(result, moveCount + 1);
                return;
            }

            if(inRange(nx, ny) && !visited[nx][ny] && !nums[field[nx][ny]]) {
                visited[nx][ny] = true;
                nums[field[nx][ny]] = true;
                dfs(nx, ny, moveCount + 1, i);
                visited[nx][ny] = false;
                nums[field[nx][ny]] = false;
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}