import java.io.*;
import java.util.*;

public class SWEA_1247 {
	
	static class location{
		int x;
		int y;
		public location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static location com;
	static location house;
	static location[] customers;
	static boolean[] visited;
	
	static int T, N, result;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			customers = new location[N];
			visited = new boolean[N];
			result = Integer.MAX_VALUE;
			
			putVal();
			
			dfs(com, 0, 0);
			
			sb.append("#").append(tc).append(" " ).append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int getDist(location curr, location house) {
		return Math.abs(curr.x - house.x) + Math.abs(curr.y - house.y);
	}
	
	private static void dfs(location curr, int count, int dist){
		if(dist >= result) {
			return;
		}
		
		if(count == N) {
			int totalDist = dist + getDist(curr, house);
			result = Math.min(totalDist, result);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int nextDist = dist + getDist(curr, customers[i]);
				
				dfs(customers[i], count + 1, nextDist);
				
				visited[i] = false;
			}
		}
		
		
	}
	
	private static void putVal() throws IOException{
		st = new StringTokenizer(br.readLine());
		com = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		house = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
		
		for(int i = 0; i < N; i++) {
			customers[i] = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
}
