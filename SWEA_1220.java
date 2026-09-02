import java.io.*;
import java.util.*;

class SWEA_1220 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        for(int i = 1 ; i <= 10; i++){

            arr = new int[100][100];
            putValues();


        }
    }

    public static void putValues() throws IOException {
        for(int i = 0 ; i < 100; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 100; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}