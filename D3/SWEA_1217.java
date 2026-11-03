import java.util.Scanner;

class SWEA_1217 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 10; i++){
            int caseNum = sc.nextInt();

            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println("#" + caseNum + " " + Recursion(N, M));
        }
    }

    static int Recursion(int N, int M) {
        if(M==0) return 1;
        int fast = Recursion(N, M / 2);

        if(M%2==0){
            return fast * fast;
        } else {
            return fast * fast * N;
        }
    }
}