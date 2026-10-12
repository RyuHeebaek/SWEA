import java.io.*;

public class SWEA_2005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
//		for(int t = 1; t <= T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			int[][] arr = new int[N][N];
//			sb.append("#").append(t).append("\n");
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j <= i; j++) {
//					if(j == 0 || j == i) {
//						arr[i][j] = 1;
//					} else {
//						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//					}
//					sb.append(arr[i][j]).append(" ");
//				}
//				sb.append("\n");
//			}
//		}
//		System.out.println(sb);
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] memo = new int[N];
			sb.append("#").append(t).append("\n");
			for(int i = 0; i < N; i++) {
				memo[i] = 1;
				
				for(int j = i - 1; j > 0; j--) {
					memo[j] = memo[j - 1] + memo[j];
				}
				
				for(int j = 0; j <= i; j++) {
					sb.append(memo[j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}