import java.io.*;
import java.util.*;

class SWEA_5658 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb, result;

    public static void main(String[] args) throws IOException{
        int testCases = Integer.parseInt(br.readLine());
        result = new StringBuilder();
        for(int i = 1; i <= testCases; i++) {


            Set<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            sb = new StringBuilder(br.readLine());

            int lengthOfOneSide = N / 4;

            for(int turn = 0; turn < lengthOfOneSide; turn++) {

                for(int j = 0; j < N; j += lengthOfOneSide) {
                    String sub = sb.substring(j, j + lengthOfOneSide);
                    int val = Integer.parseInt(sub, 16);
                    set.add(val);
                }

                char last = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.insert(0, last);
            }

            result.append("#").append(i).append(" ")
                    .append(set.stream().sorted(Comparator.reverseOrder()).skip(K-1)
                            .findFirst().orElse(-1)).append("\n");

        }
        System.out.println(result);
    }

}