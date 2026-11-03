import java.io.*;
import java.util.StringTokenizer;

class SWEA_2072 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testcases = Integer.parseInt(br.readLine());
		int result;
		
		for(int tc = 1; tc <= testcases; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			result = 0;
			
			for(int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num % 2 != 0) result += num;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}