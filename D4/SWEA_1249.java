import java.io.*;
import java.util.*;

public class SWEA_1249 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, minimumTime;
	static int[] start, end;
	static char[][] fild;
	static boolean[][] visited;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int recover;
		public Node(int x, int y, int recover) {
			this.x = x;
			this.y = y;
			this.recover = recover;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.recover, o.recover);
		}
	}
	
	public static void main(String[] args) throws IOException{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			minimumTime = 0;
			N = Integer.parseInt(br.readLine());
			fild = new char[N][N];
			visited = new boolean[N][N];
			start = new int[] {0, 0};
			end = new int[] {N-1, N-1};
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++ ) {
					fild[i][j] = str.charAt(j);
				}
			}
			
			bfs();
			
			sb.append("#").append(t).append(" ").append(minimumTime).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static boolean canMove(int x, int y) {
		return inRange(x, y) && !visited[x][y];
	}
	
	public static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start[0], start[1], 0));
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			if(curr.x == end[0] && curr.y == end[1]) {
				minimumTime = curr.recover;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(canMove(nx, ny)) {
					queue.offer(new Node(nx, ny, curr.recover + fild[nx][ny] - '0'));
					visited[nx][ny] = true;
				}
			}
			
		}
	}
}
