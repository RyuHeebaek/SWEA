import java.io.*;
import java.util.*;

public class SWEA_1227 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static final int N = 100;
	static char[][] fild;
	static int[] startIdx, endIdx;
	static int result;
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			fild = new char[N][N];
			result = 0;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					char c = str.charAt(j);
					fild[i][j] = c;
					if(c == '2') {
						startIdx = new int[] {i, j};
					} else if(c == '3') {
						endIdx = new int[] {i, j};
					}
				}
			}
			
			dfs(startIdx[0], startIdx[1]);
			
			System.out.println(result);
		}
	}
	
	public static void dfs(int x, int y) {
	
		if(fild[x][y] == '1') return;
		
		if(x == endIdx[0] && y == endIdx[1]) {
			result = 1;
			return;
		}
		
		fild[x][y] = '1';
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			dfs(nx, ny);
		}
		
	}
}
