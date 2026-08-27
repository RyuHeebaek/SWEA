import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1206{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] buildings;
    static int result;

    public static void main(String[] args) throws IOException {

        int TestCase = 10;

        for(int i = 1; i <= TestCase; i++){

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            result = 0;

            buildings = new int[N];

            for(int k = 0; k < N; k++){
                buildings[k] = Integer.parseInt(st.nextToken());
            }

            for(int check = 2; check < N-2; check++) {
                int BD_MAX = Math.max(Math.max(buildings[check + 1], buildings[check + 2]),Math.max(buildings[check-1], buildings[check-2]));
                if(buildings[check] > BD_MAX){
                    result += buildings[check] - BD_MAX;
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}