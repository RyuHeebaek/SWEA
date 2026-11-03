import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(t).append(" ").append(Math.round(sum / 10.0)).append("\n");
		}
		System.out.println(sb);
	}
}
