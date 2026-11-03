import java.io.*;
import java.util.*;

class SWEA_1208 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] nums;

    public static void main(String[] args) throws IOException {

        for(int i = 0; i < 10; i++) {

            nums = new int[100];

            int T = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());


            for(int j = 0; j < 100; j++){
                nums[Integer.parseInt(st.nextToken()) - 1]++;
            }

            int idxFront = 0;
            int idxBack = 99;

            while (nums[idxFront] == 0) idxFront++;
            while (nums[idxBack] == 0) idxBack--;

            int count = 0;

            while(count < T && idxFront < idxBack){

                nums[idxFront]--;
                nums[idxFront + 1]++;

                nums[idxBack]--;
                nums[idxBack - 1]++;

                count++;

                if(nums[idxBack] == 0){
                    idxBack--;
                }
                if(nums[idxFront] == 0){
                    idxFront++;
                }

            }

            int answer = (idxBack + 1) - (idxFront + 1);
            System.out.println("#" + (i + 1) + " " + answer);

        }
    }
}