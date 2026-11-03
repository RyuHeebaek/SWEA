import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1225 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr = new int[8];

    public static void main(String[] args) throws IOException {

        for(int i = 1 ; i <= 10; i++){
            br.readLine();

            numSort();

            StringBuilder sb = new StringBuilder();

            for (int k : arr) {
                sb.append(k);
                sb.append(" ");
            }

            System.out.println("#" + (i) + " " + sb);
        }
    }

    public static void numSort() throws IOException{

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;

        do {
            arr[0] -= num;

            num = (num % 5) + 1;

            if (arr[0] < 0) {
                arr[0] = 0;
            }

            int temp = arr[0];

            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }

            arr[arr.length - 1] = temp;

        } while (arr[arr.length - 1] != 0);
    }
}
