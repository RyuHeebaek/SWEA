import java.util.*;
import java.io.*;

class SWEA_3260_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean leftOrRight;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        int tsetCases = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tsetCases; i++){

            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            boolean leftOrRight  = str1.length() >= str2.length();

            int length = Math.max(str1.length(), str2.length());

            arr = new int[length + 1];


            sb.append("#").append(i).append(" ").append(cal(str1, str2, length)).append("\n");
        }

    }

    static void putBiggestNumber(){

    }

    static int cal(String str1, String str2, int len) {



        return 0;
    }
}
