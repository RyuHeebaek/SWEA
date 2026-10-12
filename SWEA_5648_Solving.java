import java.io.*;
import java.util.*;

public class SWEA_5648_Solving {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, totalEnergy;
	static int[][] fild;
	
	static Deque<Atom> queue;
	static LinkedList<Atom> list = new LinkedList<>();
	
	public static void reset() {
		fild = new int[4001][4001];
		totalEnergy = 0;
	}
	
	static class Atom{
		int x;
		int y;
		int direction;
		int energy;
		public Atom(int y, int x, int direction, int energy) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.energy = energy;
		}
	}
	
	public static boolean inRange(Atom a) {
		return a.x >= 0 && a.x < 4001 && a.y >= 0 && a.y < 4001;
	}
	
	public static void move(Atom a) {
		int x = a.x + dx[a.direction];
		int y = a.y + dy[a.direction];
		fild[x][y]++;
		queue.offer(new Atom(x, y, a.direction, a.energy));
	}
	
	public static void check() {
		for(int i = 0; i < queue.size(); i++) {
			Atom curr = queue.poll();
			int x = curr.x;
			int y = curr.y;
			if(fild[x][y] > 1) {
				fild[x][y]--;
				totalEnergy += curr.energy;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t < T; t++) {
			queue = new ArrayDeque<>();
			N = Integer.parseInt(br.readLine().trim());
			reset();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				queue.offer(new Atom(Integer.parseInt(st.nextToken())*2 + 2000, Integer.parseInt(st.nextToken())*2 + 2000, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	
			}
			while(!queue.isEmpty()) {
				
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					Atom curr = queue.poll();
					if(inRange(curr)) {
						move(curr);
					}
				}
				check();
			}
			System.out.println(totalEnergy);
		}
		
	}
	
}