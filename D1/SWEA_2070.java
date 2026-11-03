import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2070 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			String equal = null;
			if(a > b) {
				equal = ">";
			} else if(a < b) {
				equal = "<";
			} else {
				equal = "=";
			}
			sb.append("#").append(t).append(" ").append(equal).append("\n");
		}
		System.out.println(sb);
	}
}
