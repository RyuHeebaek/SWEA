import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class SWEA_3260 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = sc.nextInt();

        for(int i = 1; i <= testCases; i++) {
            BigInteger A = sc.nextBigInteger();
            BigInteger B = sc.nextBigInteger();

            System.out.println("#" + i + " " + A.add(B));
        }
    }
}
