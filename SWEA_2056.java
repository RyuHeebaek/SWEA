import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SWEA_2056 {
	
	static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc <= T; tc++) {
			char[] input = br.readLine().toCharArray();

            int month = (input[4] - '0') * 10 + (input[5] - '0');
            int day = (input[6] - '0') * 10 + (input[7] - '0');

            sb.append('#').append(tc).append(' ');

            if (month >= 1 && month <= 12 && day >= 1 && day <= days[month]) {
 
                sb.append(input, 0, 4).append('/')
                  .append(input, 4, 2).append('/')
                  .append(input, 6, 2).append('\n');
            } else {
                sb.append("-1\n");
            }
		}
		System.out.println(sb);
	}
}
