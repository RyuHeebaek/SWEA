import java.util.*;
import java.io.*;

public class SWEA_5644 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] movex = {0, -1, 0, 1, 0};
	static int[] movey = {0, 0, 1, 0, -1};
	static char[] move = {0, 1, 2, 3, 4};
	
	static int[][] fild;
	static List<int[]> ap;
	
	static int[] person1;
	static int[] person2;
	
	// M = Move / A = AP 
	static int M, A;
	static int sum;

	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		
		int TestCases = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TestCases; tc++) {
			fild = new int[10][10];
			getPeoplesMove();
			getAp();
			
			//AP 설치
			for(int setting = 0; setting < ap.size(); setting++) {
//				putApToFild();
			}
			
			
			
			sb.append("#").append(tc).append(" ").append("\n");
		}
		System.out.println(sb);
	}
	
//	public static void putApToFild() {
//		int[] getAp = ap.getFirst();
//		int apX = getAp[0];	//4
//		int apY = getAp[1];	//4
//		int apLen = getAp[2];
//		int apPower = getAp[3];
//		
//		for(int x = 0; x < fild.length; x++) {
//			for(int y = 0; y < fild.length; y++) {
//				if((Math.abs(apY - y) + Math.abs(apX - x)) <= apLen) {
//					fild[y][x]++;
//				}
//			}
//		}
//		
//	}
	
	public static void getAp() throws IOException{
		ap = new ArrayList<>();
		
		// [][x] [y][] range power
		for(int i = 0; i < A; i++) {
			ap.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}
	}
	
	public static void getPeoplesMove() throws IOException{
	
		StringTokenizer st1, st2;
		st1 = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st1.nextToken());
		A = Integer.parseInt(st1.nextToken());
		
		st1 = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			person1[i] = Integer.parseInt(st1.nextToken());
			person2[i] = Integer.parseInt(st2.nextToken());
		}
		
	}
}
