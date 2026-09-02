import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SWEA_1224{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;


    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        //테스트케이스 반복 시작
        for(int t = 1; t <= T; t++){

            String str = br.readLine();
            int count = str.charAt(str.length()-1) - '0';

            arr = new int[str.length()-2];

            for(int i = 0; i < str.length() - 2; i++){
                arr[i] = str.charAt(i) - '0';
            }

            sort(count);

            StringBuilder sb = new StringBuilder();

            for (int j : arr) {
                sb.append(j);
            }

            System.out.println("#" + t + ' '+ sb);

        }

    }

    static void sort(int count) {

        for(int i = 0; i < count; i++){

            int MAX_VAL = 0;
            int idx = 0;

            //바꿀 값 찾기
            for(int j = 0; j < arr.length; j++){
                if (MAX_VAL != arr[j]) {
                    MAX_VAL = Math.max(MAX_VAL, arr[j]);
                }
                idx = j;
                System.out.print(MAX_VAL + " ");
                System.out.println(idx);
            }

            for(int j = 0; j < arr.length; j++){
                if(arr[j] < MAX_VAL){
                    int temp = arr[j];
                    arr[j] = MAX_VAL;
                    arr[idx] = temp;
                    break;
                }
            }

        }
    }
}
