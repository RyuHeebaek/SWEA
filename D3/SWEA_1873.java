import java.io.*;
import java.util.*;

class SWEA_1873 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    static String[][] fild;
    static int startXIdx, startYIdx;

    public static void main(String[] args) throws IOException{

        int testCases = Integer.parseInt(br.readLine());

        for(int testcase = 0; testcase < testCases; testcase++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            fild = new String[H][W];
            startXIdx = 0;
            startYIdx = 0;
            putFild(H, W);


        }

    }

    public static void putFild(int H, int W) throws IOException {
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                fild[i][j] = st.nextToken();
                if (Objects.equals(fild[i][j], "<") || (Objects.equals(fild[i][j], ">")
                        || (Objects.equals(fild[i][j], "v") || (Objects.equals(fild[i][j], "^"))))) {
                            startXIdx = i; startYIdx = j;
                }

            }
        }
    }


}