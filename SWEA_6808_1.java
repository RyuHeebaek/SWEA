import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_1 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, totalWin, totalLose;
    static int[] kyuCars, inyCards, resultCards;
    static boolean[] kyu, isUsed;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            totalWin = totalLose = 0;
            kyu = new boolean[19];
            isUsed = new boolean[9];
            kyuCars = inyCards = resultCards = new int[9];
            getCards();



            sb.append("#").append(t).append(" ").append(totalWin).append(" ").append(totalLose).append("\n");
        }
        System.out.println(sb);
    }

    private static void check() {
        int win = 0;
        int lose = 0;
        for(int i = 0; i < 9; i++) {
            if(resultCards[i] > kyuCars[i]) win++;
            else if(inyCards[i] < kyuCars[i]) lose++;
        }

        if(win > lose) {
            totalWin++;
        } else if (lose > win) {
            totalLose++;
        }
    }

    private static void dfs(int cards) {
        if(cards == 9) {
            check();
            return;
        }

        for(int i = 0; i < 9; i++) {

        }
    }

    private static void getCards() throws IOException{
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 9; i++) {
            int card = Integer.parseInt(st.nextToken());
            kyuCars[i] = card;
            kyu[card] = true;
        }

        int idx = 0;
        for(int i = 1; i < 19; i++) {
            if(!kyu[i]) {
                inyCards[idx++] = i;
            }
        }
    }
}
