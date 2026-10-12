import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class GasPipe_BeakJoon {
	
	static char[] pipes = {'|', '-', '+', '1', '2', '3', '4'};
	static char[][] fild;
	static boolean[][] visited;
	// 아 오 위 윈
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int R, C, emptyX, emptyY, direction;
	// 아 오 위 왼
	static boolean[] canConnect = new boolean[4];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[] start = new int[2];
		int[] end = new int[2];
		fild = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				fild[i][j] = ch;
				if(ch == 'M') {
					start[0] = i;
					start[1] = j;
				} else if(ch == 'C') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		bfs(start, end);
		find();
		getPipeType(canConnect);
	}
	
	public static char getPipeType(boolean[] conn) {
        boolean up = conn[0], down = conn[1], left = conn[2], right = conn[3];

        if (up && down && left && right) return '+';
        if (up && down) return '|';
        if (left && right) return '-';
        if (down && right) return '1';
        if (up && right) return '2';
        if (up && left) return '3';
        if (down && left) return '4';

        return ' ';
    }
	
	public static void find() {
		for(int i = 0; i < 4; i++) {
			int x = emptyX + dx[i];
			int y = emptyY + dy[i];
			
			if(fild[x][y] != '.') {
				canConnect[i] = true;
			}
		}
		
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
	
	public static boolean canMove(int x, int y) {
		return inRange(x, y) && !visited[x][y] && fild[x][y] != '.';
	}
	
	public static void bfs(int[] start, int[] end) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {

			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			
			if(x == end[0] && y == end[1]) {
				
			}
			
			int count = 0;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(canMove(nx, ny)) {
					int pipeNum = 0;
					for(int c = 0; c < pipes.length; c++) {
						if(pipes[c] == fild[x][y]) {
							pipeNum = c;
						}
					}
					queue.offer(new int[] {nx, ny, pipeNum});
					count++;
					visited[nx][ny] = true;
				}
			}
			
			if(count == 0) {
				emptyX = x;
				emptyY = y;
				direction = curr[2];
				return;
			}
			
		}
	}
}
