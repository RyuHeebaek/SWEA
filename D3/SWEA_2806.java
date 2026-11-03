import java.util.*;
import java.io.*;

class SWEA_2806 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){

            N = Integer.parseInt(br.readLine());
            count = 0;
            arr = new int[N];

            nQueen(0);

            System.out.println("#" + (i+1) + " " + count);
        }

    }

    private static void nQueen(int row) {
        if(row == N){
            count++;
            return;
        }

        for(int col = 0; col < N; col++){
            arr[row] = col;

            if(isPromising(row)){
                nQueen(row + 1);
            }
        }
    }

    private static boolean isPromising(int row) {
        for(int i = 0 ; i < row; i++) {
            if(arr[i] == arr[row]) {
                return false;
            }

            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])){
                return false;
            }
        }
        return true;
    }
}