import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1859 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine().trim());

        for(int i = 0 ; i < testCase; i++){
            int N = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for(int j = 0 ; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken().trim());
            }


            System.out.println("#" + (i+1) + " "+ buyOrSell(arr));
        }
    }

    public static long buyOrSell(int[] arr){

        int maxPrice = arr[arr.length-1];
        long totalProfit = 0;

        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] < maxPrice){
                totalProfit += maxPrice - arr[i];
            } else {
                maxPrice = arr[i];
            }
        }

        return totalProfit;
    }
}
