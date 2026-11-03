import java.io.*;
import java.util.*;

public class SWEA_6808_2 {
	
	static int[] kyu, iny, selected;
	static boolean[] nums, visited;;
	static int totalWin, totalLose;
	
	public static void main(String[] args) throws IOException{
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			reset();
			st = new StringTokenizer(br.readLine());
			getInput(st);
			dfs(0);
			sb.append("#").append(t).append(" ").append(totalWin).append(" ").append(totalLose).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void check() {
		int win = 0;
		int lose = 0;
		for(int i = 0; i < 9; i++) {
			if(kyu[i] > selected[i]) win += kyu[i] + selected[i];
			else if(kyu[i] < selected[i]) lose += kyu[i] + selected[i];
		}
		
		if(win > lose) totalWin++;
		else if(win < lose) totalLose++;
	}
	
	public static void dfs(int depth) {
		if(depth == 9) {
			check();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = iny[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void reset() {
		kyu = new int[9];
		iny = new int[9];
		selected = new int[9];
		nums = new boolean[19];
		visited = new boolean[9];
		totalWin = totalLose = 0;
	}
	
	public static void getInput(StringTokenizer st) {
		for(int i = 0; i < 9; i++) {
			int num = Integer.parseInt(st.nextToken());
			kyu[i] = num;
			nums[num] = true;
		}
		
		int idx = 0;
		for(int i = 1; i < 19; i++) {
			if(!nums[i]) iny[idx++] = i;
		}
	}
}
