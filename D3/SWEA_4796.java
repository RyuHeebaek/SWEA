import java.io.IOException;
import java.util.Scanner;
public class SWEA_4796 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int TestCases = sc.nextInt();
        for(int tc = 1; tc <= TestCases; tc++) {

            String line;

            int N = sc.nextInt();

            long sum = 0;
            int left = 0;
            int right = 0;

            int prev = sc.nextInt();

            for(int i = 1; i < N; i++) {
                int curr = sc.nextInt();

                if(curr > prev) {
                    if(right > 0) {
                        sum += (long) left * right;
                        left = 0;
                        right = 0;
                    }
                    left++;
                } else if (curr < prev) {
                    if(left > 0) {
                        right++;
                    }
                }
                prev = curr;
            }

            if(left > 0 && right > 0) {
                sum += (long) left * right;
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");

        }
        System.out.println(sb);
    }

}
