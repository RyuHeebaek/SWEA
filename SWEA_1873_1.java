import java.io.*;
import java.util.*;

public class SWEA_1873_1 {

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static final String TANK_SYMBOLS = "^>v<";
    static final String DIRS = "URDL";

    static int H, W, r, c, dir;
    static char[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        int testCases = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][];
            r = c = dir = 0;

            for(int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            br.readLine();
            char[] command = br.readLine().toCharArray();

            play(command);

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; ++i) {
                for (int j = 0; j < W; ++j)
                    sb.append(map[i][j]);
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void play(char[] command) {
        LOOP: for(int i = 0; i < H; i++) {
        for(int j = 0; j < W; j++) {
            dir = TANK_SYMBOLS.indexOf(map[i][j]);
            if (dir == -1) continue;

            r = i;
            c = j;

            break LOOP;
        }
        }

        map[r][c] = '.';
        printDebugMap(' ');

        for(char cm : command) {
            if(cm == 's')
                shoot();
            else
                move(cm);
            printDebugMap(cm);
        }

        map[r][c] = TANK_SYMBOLS.charAt(dir);
    }

    private static void shoot() {
        int nr = r;
        int nc = c;

        while(true) {
            nr += dr[dir];
            nc += dc[dir];

            if(!isInRange(nc, nr) || map[nr][nc] == '#') break;
            if(map[nc][nr] == '*') {
                map[nc][nr] = '.';
                break;
            }
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    private static void move(char newDir) {
        dir = DIRS.indexOf(newDir);

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if(!isInRange(nc, nr) || map[nc][nr] != '.') return;

        r = nr;
        c = nc;
    }


    private static void printDebugMap(char cmd) {

        System.out.println("---------------------------------");
        System.out.println("[명령어]: " + (cmd != ' '?cmd : "없음(초기상태)"));

        System.out.println("[전차 정보] 위치: (" + r + ", " + c + ") | 방향: " + DIRS.charAt(dir));

        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                // 현재 전차 위치에는 임시로 전차 심볼을 출력
                if (i == r && j == c) {
                    System.out.print(TANK_SYMBOLS.charAt(dir));
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
