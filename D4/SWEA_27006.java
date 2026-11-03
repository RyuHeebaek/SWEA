import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_27006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < TC; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            char[][] field = new char[N][];

            for (int i = 0; i < N; i++) {
                field[i] = br.readLine().toCharArray();
            }

            int result = 0;

            for (int d = 0; d < N; d++) {
                boolean symmetric = true;

                CHECK:
                for (int i = 0; i < N; i++) {
                    // 대각선은 항상 같고, 반대쪽은 중복이므로 i < j만 검사
                    for (int j = i + 1; j < N; j++) {
                        if (field[i][(j + d) % N]
                                != field[j][(i + d) % N]) {
                            symmetric = false;
                            break CHECK;
                        }
                    }
                }

                if (symmetric) {
                    result += N;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}