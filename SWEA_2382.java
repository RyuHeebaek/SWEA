import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382 {

    static class Micro{
        int x;
        int y;
        int value;
        int direction;
        public Micro(int x, int y, int value, int direction) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.direction = direction;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int T, N, M, K;
    static Queue<Micro> queue = new ArrayDeque<>();

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            initialize();
            simulate();
            sb.append("#").append(t).append(" ").append(getLiveMicro()).append("\n");
        }
        System.out.println(sb);
    }

    public static void simulate() {
        for(int time = 0; time < M; time++) {
            if(queue.isEmpty()) break;

            int[][] sum = new int[N][N];
            int[][] maxVal = new int[N][N];
            int[][] dir = new int[N][N];

            int queueSize = queue.size();
            for(int size = 0; size < queueSize; size++) {
                Micro curr = queue.poll();

                int nx = curr.x + dx[curr.direction];
                int ny = curr.y + dy[curr.direction];
                int val = curr.value;
                int d = curr.direction;

                if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
                    val /= 2;
                    d = reverseDir(d);
                }

                if(val == 0) continue;

                sum[nx][ny] += val;
                if(val > maxVal[nx][ny]) {
                    maxVal[nx][ny] = val;
                    dir[nx][ny] = d;
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(sum[i][j] > 0) {
                        queue.add(new Micro(i, j, sum[i][j], dir[i][j]));
                    }
                }
            }
        }
    }


    public static int reverseDir(int d) {
        if(d % 2 == 0) {
            return d - 1;
        } else {
            return d + 1;
        }
    }

    public static void initialize() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue.clear();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            queue.add(new Micro(x, y, value, direction));
        }
    }

    public static int getLiveMicro() {
        int total = 0;
        for(Micro m : queue) {
            total += m.value;
        }
        return total;
    }
}
