import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1979 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N + 2][N + 2];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for(int i = 1; i <= N + 1; i++) {
				int rowLen = 0;
				int colLen = 0;
				
				for(int j = 1; j <= N + 1; j++) {
					if(arr[i][j] == 1) {
						rowLen++;
					} else {
						if(rowLen == K) result++;
						rowLen = 0;
					}
					
					if(arr[j][i] == 1) {
						colLen++;
					} else {
						if(colLen == K) result++;
						colLen = 0;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
