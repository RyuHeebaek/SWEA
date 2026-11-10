import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class codeTree_Int {

    static class knight{
        int x;
        int y;
        int dist;
        knight(int x,int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][] visited;
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        knight start = new knight(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, 0);
        knight end = new knight(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, 0);
        result = 0;

        bfs(start, end);
        System.out.println(result);
    }

    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static boolean canMove(int x,int y){
        return inRange(x,y) && !visited[x][y];
    }
    static void bfs(knight start, knight end) {
        visited = new boolean[N][N];
        Queue<knight> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            knight curr = queue.poll();

            if(curr.x == end.x && curr.y == end.y){
                result = curr.dist;
                return;
            }

           for(int i=0;i<8;i++){
               int nx = curr.x + dx[i];
               int ny = curr.y + dy[i];

               if(canMove(nx,ny)){
                   queue.offer(new knight(nx, ny, curr.dist + 1));
                   visited[nx][ny] = true;
               }
           }
        }
        result = -1;
    }
}
