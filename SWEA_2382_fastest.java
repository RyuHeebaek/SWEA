import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_2382_fastest {

    static class Micro {
        int x, y, value, dir;

        public Micro(int x, int y, int value, int dir) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.dir = dir;
        }
    }

    static int T, N, M, K;
    static ArrayList<Micro> list = new ArrayList<>();
    static int[][] map;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] rev = {0, 2, 1, 4, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            list.clear();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list.add(new Micro(x, y, val, dir));
            }

            for (int time = 0; time < M; time++) {
                list.sort((a, b) -> b.value - a.value);
                ArrayList<Micro> nextList = new ArrayList<>();

                for (Micro m : list) {
                    m.x += dx[m.dir];
                    m.y += dy[m.dir];

                    if (m.x == 0 || m.x == N - 1 || m.y == 0 || m.y == N - 1) {
                        m.value /= 2;
                        m.dir = rev[m.dir];
                    }

                    if (m.value == 0) continue;

                    if (map[m.x][m.y] == 0) {
                        map[m.x][m.y] = m.value;
                        nextList.add(m);
                    } else {
                        map[m.x][m.y] += m.value;
                    }
                }

                for (Micro m : nextList) {
                    m.value = map[m.x][m.y];
                    map[m.x][m.y] = 0;
                }

                list = nextList;
            }

            int total = 0;
            for (Micro m : list) {
                total += m.value;
            }

            sb.append("#").append(t).append(" ").append(total).append("\n");
        }
        System.out.print(sb);
    }
}