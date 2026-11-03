import java.util.*;
import java.io.*;

public class SWEA_1486 {
	
	static int[] emps;
	static boolean[] isPossible;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCases; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//점원 
			int N = Integer.parseInt(st.nextToken());
			emps = new int[N];
			//책장 높이
			int B = Integer.parseInt(st.nextToken());
			isPossible = new boolean[200000];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				emps[i] = Integer.parseInt(st.nextToken());
			}
			
			check();
			
			sb.append("#").append(tc).append(" ").append(minNum(B)).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	public static int minNum(int B) {
		
		int idx = 0;
		
		for(int i = B; i < isPossible.length; i++) {
			if(isPossible[i]) {
				idx = i;
				break;
			}
		}
		
		return idx - B;
		
	}
	
	public static void check() {
		int n = emps.length;
		
		for(int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) != 0) {
					sum += emps[j];
				}
			}
			isPossible[sum] = true;
		}
	}
}
