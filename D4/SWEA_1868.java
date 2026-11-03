import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


class SWEA_1868 {
	
	static boolean[][] visited;
	static char[][] fild;
	
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
	
	static int N, minNum;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			fild = new char[N][N];
			visited = new boolean[N][N];
			minNum = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					fild[i][j] = str.charAt(j);
				}
			}
			
			int clickCount = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(fild[i][j] == '.' && !visited[i][j] && getMineCount(i, j) == 0) {
						clickCount++;
						bfs(i, j);
					}
				}
				
			}
			
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (fild[i][j] == '.' && !visited[i][j]) {
                        clickCount++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(clickCount).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int getMineCount(int x, int y) {
		int count = 0;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
            	if(fild[nx][ny] == '*') {
					count++;
				}	
            }
		}
		return count;
	}
	
	static void bfs(int x, int y) {
		Deque<Node> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				
				if(getMineCount(nx, ny) == 0) {
					queue.offer(new Node(nx, ny));
				}
			}
			
			
		}
	}
}