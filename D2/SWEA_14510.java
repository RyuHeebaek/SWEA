import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] trees;
    static int[] diff;
    static int maxVal;
    static int minVal;

    public static void main(String[] args) throws IOException {

        int testCases = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCases; tc++) {

            int tree = Integer.parseInt(br.readLine());
            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;
            trees = new int[tree];

            putVal();

            sb.append("#").append(tc).append(" ");
        }

    }


    public static void putVal() throws IOException{
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxVal = Math.max(trees[i], maxVal);
        }

        for(int i = 0; i < trees.length; i++) {
            diff[i] = maxVal - trees[i];
            minVal = Math.min(diff[i], minVal);
        }
    }
}