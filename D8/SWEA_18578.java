import java.util.*;
import java.io.*;

class SWEA_18578 { // SWEA Gravity 문제

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][] arr;
    static int w;
    static final int MAX_H = 100;

    static int[] nums;
    static int HIGHEST;

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        if (line == null) return;
        int testCase = Integer.parseInt(line.trim());

        for (int tc = 1; tc <= testCase; tc++) {
            w = Integer.parseInt(br.readLine().trim()); // 전역 w에 할당 (지역 변수 shadowing 제거)
            arr = new boolean[MAX_H][w];
            nums = new int[w];
            HIGHEST = 0;

            addValue();

            // 90도 회전 및 중력 작용 후 최대 낙차 계산
            int result = simulateAndGetMaxDrop();
            System.out.println("#" + tc + " " + result);
        }
    }

    public static void addValue() throws IOException {
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < w; i++) {
            int len = Integer.parseInt(st.nextToken());
            nums[i] = len;
            HIGHEST = Math.max(HIGHEST, len);

            // 상자를 아래부터 채우도록 인덱스 매핑 (MAX_H-1이 맨 바닥)
            for (int j = MAX_H - 1; j >= MAX_H - len; j--) {
                arr[j][i] = true;
            }
        }
    }

    // 시뮬레이션 기반 낙차 계산 함수
    public static int simulateAndGetMaxDrop() {
        int maxDrop = 0;

        // 각 열의 맨 위에 있는 상자의 낙차 측정
        for (int i = 0; i < w; i++) {
            if (nums[i] == 0) continue;

            // i번째 열의 맨 위 상자 높이 (0-indexed: MAX_H - nums[i])
            int topRow = MAX_H - nums[i];

            // 오른쪽으로 이동 시 장애물(다른 상자)의 개수를 셈
            int obstacleCount = 0;
            for (int nextCol = i + 1; nextCol < w; nextCol++) {
                if (arr[topRow][nextCol]) {
                    obstacleCount++;
                }
            }

            // 시계방향 90도 회전 후 중력이 작용하면:
            // (내 오른쪽 전체 공간 수) - (내 오른쪽에 존재하는 상자 개수) = 낙차
            int drop = (w - 1 - i) - obstacleCount;
            maxDrop = Math.max(maxDrop, drop);
        }

        return maxDrop;
    }
}
