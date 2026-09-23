import java.io.*;
import java.util.*;

public class SWEA_1928 {
	
	private static final int[] DECODE_TABLE = new int[128];
	
	static {
		for(int i = 0; i < 26; i++) {
			DECODE_TABLE['A' + i] = i;
		}
		for(int i = 0; i < 26; i++) {
			DECODE_TABLE['a' + i] = i + 26;
		}
		for(int i = 0; i < 10; i++) {
			DECODE_TABLE['0' + i] = i + 52;
		}
		
		DECODE_TABLE['+'] = 62;
		DECODE_TABLE['/'] = 63;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			String encodedStr = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < encodedStr.length(); i+= 4) {
				int v1 = DECODE_TABLE[encodedStr.charAt(i)];
                int v2 = DECODE_TABLE[encodedStr.charAt(i + 1)];
                int v3 = DECODE_TABLE[encodedStr.charAt(i + 2)];
                int v4 = DECODE_TABLE[encodedStr.charAt(i + 3)];
                
                int bit24 = (v1 << 18) | (v2 << 12) | (v3 << 6) | v4;
                
                char c1 = (char) ((bit24 >> 16) & 0xFF);
                char c2 = (char) ((bit24 >> 8) & 0xFF);
                char c3 = (char) (bit24 & 0xFF);
                
                sb.append(c1).append(c2).append(c3);
			}
			
			result.append("#").append(tc).append(" ").append(sb.toString()).append("\n");
		}
		
		System.out.println(result);

	}
}
