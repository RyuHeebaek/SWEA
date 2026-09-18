import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1926 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			int count = get369Count(i);
			
			if(count > 0) {
				while(count-- > 0) {
					sb.append("-");
				}
			} else sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);
	}
	
	private static int get369Count(int num) {
		int count = 0;
		while(num > 0) {
			int digit = num % 10;
			if(digit == 3 || digit == 6 || digit == 9) count++;
			num /= 10;
		}
		return count;
	}

}
