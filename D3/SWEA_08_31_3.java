import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA_08_31_3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        for(int tc = 1; tc <= 10; tc++) {

            br.readLine();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int minus = 1;

            while(true) {
                int first = queue.pop();
                int fAfterMinus = first - minus;

                if(fAfterMinus <= 0) {
                    fAfterMinus = 0;
                    queue.addLast(fAfterMinus);
                    break;
                }

                queue.addLast(fAfterMinus);
                minus = (minus % 5) + 1;
                System.out.println(minus);
            }

            sb.append("#").append(tc).append(" ")
                    .append(queue.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");

            queue.clear();

        }
        System.out.println(sb);
    }
}
