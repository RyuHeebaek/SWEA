import java.io.*;
import java.util.*;

class SWEA_1209_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int t = 0; t < 10; t++) {

            String tcStr = br.readLine();
            if (tcStr == null) break;
            int testCase = Integer.parseInt(tcStr.trim());

            int maxVal = 0;
            int leftToRight = 0;
            int rightToLeft = 0;


            int[] colSum = new int[100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                int rowSum = 0;

                for (int j = 0; j < 100; j++) {
                    int val = Integer.parseInt(st.nextToken());

                    rowSum += val;

                    colSum[j] += val;


                    if (i == j) leftToRight += val;
                    if (i + j == 99) rightToLeft += val;
                }


                maxVal = Math.max(maxVal, rowSum);
            }


            for (int sum : colSum) {
                maxVal = Math.max(maxVal, sum);
            }
            maxVal = Math.max(maxVal, Math.max(leftToRight, rightToLeft));

            System.out.println("#" + testCase + " " + maxVal);
        }
    }
}