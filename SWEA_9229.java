import java.io.*;
import java.util.*;

public class SWEA_9229 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, Max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int testcases = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testcases; i++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            Max = Integer.parseInt(st.nextToken());

            arr = new int[N];

            putValue();

            sb.append("#").append(i).append(" ").append(vailable()).append("\n");
        }
        System.out.println(sb);
    }

    public static void putValue() throws IOException {
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    public static int vailable() {
        int startIdx = 0;
        int endIdx = N - 1;

        int maxVal = -1;

        while (startIdx < endIdx){
            if (arr[startIdx] + arr[endIdx] == Max) {
                maxVal = arr[startIdx] + arr[endIdx];
                break;
            }else if(arr[startIdx] + arr[endIdx] < Max){
                maxVal = Math.max(maxVal, arr[startIdx] + arr[endIdx]);
                startIdx++;
            } else endIdx--;
        }

        return maxVal;

    }
}
