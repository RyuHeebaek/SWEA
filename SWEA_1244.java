import java.io.*;
import java.util.*;

class SWEA_1244    {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //-------------------------------------
    static char[] arr;
    static int chance;
    static int maxVal;
    static Set<String>[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            arr = st.nextToken().toCharArray();
            chance = Integer.parseInt(st.nextToken());

            maxVal = 0;

            visited = new HashSet[chance + 1];

            for(int i = 0; i < chance + 1; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0);

            System.out.println("#" + t + " " + maxVal);

        }
    }

    static void dfs(int count) {
        int currentVal = Integer.parseInt(new  String(arr));

        if(count == chance) {
            maxVal  =  Math.max(maxVal, currentVal);
            return;
        }

        String state = new  String(arr);
        if(visited[count].contains(state)){
            return;
        }
        visited[count].add(state);

        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                swap(i,j);
                dfs(count + 1);
                swap(i,j);
            }
        }
    }

    static void swap(int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}