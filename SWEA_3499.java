import java.io.*;
import java.util.*;

public class SWEA_3499 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static String[] list;
    //static LinkedList<String> list;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCases; i++){

            N = Integer.parseInt(br.readLine());
            list = new String[N];
            //list = new LinkedList<>();
            putVal();

            sb.append("#").append(i).append(" ").append(String.join(" ", list)).append("\n");
        }

        System.out.println(sb);

    }

    static void putVal() throws IOException {
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i += 2){
            list[i] = st.nextToken();
        }

        for(int i = 1; i < N; i += 2){
            list[i] = st.nextToken();
        }

//        for(int i = 0 ; i < (N / 2) + (N % 2) ; i++){
//            list.addLast(st.nextToken());
//        }
//
//        for(int i = 1; i < N; i+=2){
//            list.add(i, st.nextToken());
//        }

    }
}
