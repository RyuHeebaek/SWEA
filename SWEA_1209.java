import java.io.*;
import java.util.*;

class SWEA_1209 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr = new int[100][100];

    static int MAX_VERTICAL;
    static int MAX_HORIZONTAL;
    static int MAX_CROSS;

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 10; i++){

            int TestCase = Integer.parseInt(br.readLine());

            putValue();

            maxValueOfVertical();
            maxValueOfHorizontal();
            maxValueOfCross();

            int answer = Math.max(MAX_CROSS, Math.max(MAX_VERTICAL, MAX_HORIZONTAL));

            System.out.println("#" + TestCase + " " + answer);
        }
    }

    public static void putValue() throws IOException{
        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void maxValueOfCross(){

        MAX_CROSS = 0;

        int leftToRight = 0;
        int rightToLeft = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(i == j){
                    leftToRight += arr[i][j];
                }

                if(i + j == 99){
                    rightToLeft += arr[i][j];
                }
            }
        }
        MAX_CROSS = Math.max(leftToRight, rightToLeft);
    }

    public static void maxValueOfVertical(){

        MAX_VERTICAL = 0;

        for(int i = 0; i < arr.length; i++){

            int valueOfVertical = 0;

            for(int j = 0; j < arr[i].length; j++){
                valueOfVertical += arr[i][j];
            }
            MAX_VERTICAL = Math.max(valueOfVertical, MAX_VERTICAL);
        }
    }

    public static void maxValueOfHorizontal(){

        MAX_HORIZONTAL= 0;

        for(int i = 0; i < arr.length; i++){

            int valueOfHorizontal = 0;

            for(int j = 0; j < arr[i].length; j++){
                valueOfHorizontal += arr[j][i];
            }
            MAX_HORIZONTAL = Math.max(valueOfHorizontal, MAX_HORIZONTAL);
        }
    }
}