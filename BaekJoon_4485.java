import java.io.*;
import java.util.*;

public class BaekJoon_4485 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, result;
	static int[][] fild;
	static boolean[][] visited;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int stealed;
		public Node(int x, int y, int stealed) {
			this.x = x;
			this.y = y;
			this.stealed = stealed;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.stealed, o.stealed);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int TestCaseNum = 1;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			fild = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					fild[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0, N-1, N-1);
			sb.append("Problem ").append(TestCaseNum++).append(": ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static boolean canMove(int x, int y) {
		return inRange(x, y) && !visited[x][y];
	}
	
	public static void dfs(int startX, int startY, int endX, int endY) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.x == endX && curr.y == endY) {
				result = curr.stealed;
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if(canMove(nx, ny)) {
					queue.offer(new Node(nx, ny, curr.stealed + fild[nx][ny]));
					visited[nx][ny] = true;
				}
			}
		}
	}
}
