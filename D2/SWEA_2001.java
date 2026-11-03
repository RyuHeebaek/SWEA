import java.util.*;
import java.io.*;

public class SWEA_2001 {
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N + 1][N + 1];
			int M = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
				}
			}
			
			int maxVal = 0;
			for(int i = M; i <= N; i++) {
				for(int j = M; j <= N; j++) {
					int sum = arr[i][j] - arr[i-M][j] - arr[i][j-M] + arr[i-M][j-M];
					System.out.println(arr[i][j]);
					maxVal = Math.max(maxVal, sum);
				}
			}
			sb.append("#").append(tc).append(" ").append(maxVal).append("\n");
		}
		System.out.println(sb);
	}
}
