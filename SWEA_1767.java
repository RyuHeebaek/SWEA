import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1767{

    static int[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws IOException {

        //testCase 받아오기
        int TestCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= TestCase; t++){

            // 배열 크기 받아오기
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            addNum();



        }
    }

    public static void addNum() throws IOException {

        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
