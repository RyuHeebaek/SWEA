//import java.util.*;
//import java.io.*;
//
//public class SWEA_3421 {
//<<<<<<< HEAD
//	
//=======
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
//	static StringBuilder sb = new StringBuilder();;
//	static int N, M;
//	static boolean[][] isBad;
//	static boolean[] selected;
//	static int count;
//<<<<<<< HEAD
//	
//	public static void main(String[] args) throws IOException{
//		int TestCase = Integer.parseInt(br.readLine());
//		
//		for(int tc = 1; tc <= TestCase; tc++) {
//			
//				
//=======
//
//	public static void main(String[] args) throws IOException{
//		int TestCase = Integer.parseInt(br.readLine());
//
//		for(int tc = 1; tc <= TestCase; tc++) {
//
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//			st = new StringTokenizer(br.readLine());
//			// 숫자 개수
//			N = Integer.parseInt(st.nextToken());
//			// 입력 줄 개수
//			M = Integer.parseInt(st.nextToken());
//			// 같이 들어가면 안되는 수 저장
//			isBad = new boolean[N + 1][N + 1];
//			selected = new boolean[N + 1];
//			putBads();
//			count = 0;
//<<<<<<< HEAD
//			
//			dfs(1);
//			
//			sb.append("#").append(tc).append(" " ).append(count).append("\n");
//		}
//		System.out.println(sb);
//	
//	}
//	
//=======
//
//			dfs(1);
//
//			sb.append("#").append(tc).append(" " ).append(count).append("\n");
//		}
//		System.out.println(sb);
//
//	}
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//	static void putBads() throws IOException{
//		for(int i = 0 ; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//<<<<<<< HEAD
//			
//=======
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//			isBad[a][b] = true;
//			isBad[b][a] = true;
//		}
//	}
//<<<<<<< HEAD
//	
//=======
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//	static void dfs(int idx) {
//		if(idx > N) {
//			count++;
//			return;
//		}
//<<<<<<< HEAD
//		
//=======
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//		// 1. 현재 원소(idx)를 포함하는 경우
//		boolean canSelect = true;
//		for(int i = 1; i < idx; i++) {
//			if(selected[i] && isBad[i][idx]) {
//				canSelect = false;
//				break;
//			}
//		}
//<<<<<<< HEAD
//		
//=======
//
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
//		if(canSelect) {
//			selected[idx] = true;
//			dfs(idx + 1);
//			selected[idx] = false;
//		}
//<<<<<<< HEAD
//		
//		// 2. 현재 원소(idx)를 포함하지 않는 경우
//		dfs(idx + 1);
//	}
//}
////4193   
//=======
//
//		dfs(idx + 1);
//	}
//}
////4193
//>>>>>>> a46191939e4f9c0ec223ba0bc9f248f7ff5ab2c3
