import java.util.*;
import java.io.*;

public class SWEA_1204 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] score;
		
		int testCases = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= testCases; tc++) {
			score = new int[101];
			br.readLine();
			int maxVal = Integer.MIN_VALUE;
			int maxIdx = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 1000; i++) {
				int idx = Integer.parseInt(st.nextToken());
				score[idx]++;
				if(maxVal <= score[idx]) {
					maxVal = Math.max(maxVal, score[idx]);
					maxIdx = idx;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxIdx).append("\n");
		}
		System.out.println(sb);
	}
	
}
