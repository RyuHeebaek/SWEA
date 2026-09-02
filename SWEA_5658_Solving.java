import java.io.*;
import java.util.*;

class SWEA_5658 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static char[] arr;
    static Set<String> values;

    public static void main(String[] args) throws IOException{
        int TestCase = Integer.parseInt(br.readLine().trim());

        for(int t = 1; t <= TestCase; t++){
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }


    }

    public static void putValues() throws IOException {
        arr = br.readLine().toCharArray();

        int length = N / 4;

        for(int i = 0; i < arr.length; i+=length){



        }
    }
}