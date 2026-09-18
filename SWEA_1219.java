import java.io.*;

public class SWEA_1219 {
	
	static final int N = 100;
	static char[][] fild = new char[N][N]; 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < 2; t++) {
			int TC = Integer.parseInt(br.readLine().trim());
			
			for(int i = 0; i < 100; i++) {
				fild[i] = br.readLine().trim().toCharArray();
			}
			
			int maxLen = 1;
			
			for(int len = N; len > maxLen; len--) {
				if(findPalindrome(len)) {
					maxLen = len;
					break;
				}
			}
			sb.append("#").append(TC).append(" ").append(maxLen).append("\n");
		}
		System.out.print(sb);
	}
	
	public static boolean findPalindrome(int len) {
		for(int i = 0; i < N; i++) {
			for(int start = 0; start <= N - len; start++) {
				int end = start + len -1;
				
				if(isPalindromeRow(i, start, end)) return true;
				
				if(isPalindromeCol(i, start, end)) return true;
			}
		}
		return false;
	}
	
	public static boolean isPalindromeRow(int row, int s, int e) {
		while(s < e) {
			if(fild[row][s++] != fild[row][e--]) return false;
		}
		
		return true;
	}
	
	public static boolean isPalindromeCol(int cal, int s, int e) {
		while(s < e) {
			if(fild[s++][cal] != fild[e--][cal]) return false;
		}
		
		return true;
	}

}
