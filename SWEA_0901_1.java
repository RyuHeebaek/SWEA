import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0901_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int testCases = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCases; tc++) {

            int N = Integer.parseInt(br.readLine());

            String[] shuffle = new String[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i+=2) {
                shuffle[i] = st.nextToken();
            }
            for(int i = 1; i < N; i+=2) {
                shuffle[i] = st.nextToken();
            }



            sb.append("#").append(tc).append(" ").append(String.join(" ", shuffle)).append("\n");
        }
        System.out.println(sb);
    }

}
