import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution{
	
	static int[] memo = new int[100000];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(memo, -1);
		
		int testCases = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCases; tc++) {
			
			int num = Integer.parseInt(br.readLine());
			
			int maxTurns = dfs(num);
			
			sb.append("#").append(tc).append(" ").append(maxTurns).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dfs(int num) {
		
		// input이 10미만이면 break
		if(num < 10) {
			return 0;
		}
		
		
		//이미 계산했던 경우는 계산한거 사용
		if(memo[num] != -1) {
			return memo[num];
		}
		
		String str = String.valueOf(num);
		int len = str.length();
		int maxTurn = 0;
		
		for(int i = 1; i < (1<<(len - 1)); i++) {
			int multiplyVal = 1;
			int startIdx = 0;
			
			for(int j = 0; j < len - 1; j++) {
				if((i & 1<<j) != 0) {
					multiplyVal *= Integer.parseInt(str.substring(startIdx, j+1));
					startIdx = j + 1;
				}
			}
			
			multiplyVal *= Integer.parseInt(str.substring(startIdx));
			
			maxTurn = Math.max(maxTurn, 1 + dfs(multiplyVal));
		}
		
		return memo[num] = maxTurn;
	}
}