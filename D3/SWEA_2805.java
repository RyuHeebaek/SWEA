import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SWEA_2805{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCases ; i++){

            N = Integer.parseInt(br.readLine());
            result =0;

            for(int x = 0 ; x < N ; x++){

                int distance = Math.abs(x - N/2);
                char[] charr = br.readLine().toCharArray();

                for(int y = distance; y < N-distance; y++){
                    result += charr[y] - '0';
                }

            }

            System.out.println("#" + (i+1) + " " + result);

        }
    }
}
