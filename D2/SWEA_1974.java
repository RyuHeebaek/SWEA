import java.io.*;
import java.util.*;

public class SWEA_1974 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T;
	static int[][] fild;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			fild = new int[9][9];
			int result = -1;
			
			putVal();
			
			result = check();
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			}
			System.out.println(sb);
		}
	
	private static int check() {
		for(int i = 0; i < 9; i++) {
			boolean[] check1 = new boolean[10];
			boolean[] check2 = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(check1[fild[i][j]] || check2[fild[j][i]]) {
					System.out.println(-12);
					return 0;
				}
				check1[fild[i][j]] = check2[fild[j][i]] = true;
			}
		}
		
		return 1;
	}
	
	private static void putVal() throws IOException {
		StringTokenizer st = null;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				fild[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

