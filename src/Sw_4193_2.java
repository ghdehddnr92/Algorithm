//import java.awt.Point;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Sw_4193_2 {
//   static int N;
//   static int map[][];
//   static int sy,sx,ey,ex;
//   static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
//   static boolean visited[][];
//   public static void main(String...msg) throws IOException {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      int TestCase = Integer.parseInt(br.readLine());
//      for(int T = 1; T<= TestCase; T++) {
//         N = Integer.parseInt(br.readLine());
//         map = new int[N][N];
//         visited = new boolean[N][N];
//         for(int i = 0 ; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j = 0 ; j < N; j++) {
//               map[i][j] = Integer.parseInt(st.nextToken());
//            }
//         }
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         sy = Integer.parseInt(st.nextToken());
//         sx = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         ey = Integer.parseInt(st.nextToken());
//         ex = Integer.parseInt(st.nextToken());
//         BFS(T);
//      }
//   }
//
//   public static void BFS(int T) {
//      Queue<Point> q = new LinkedList<Point>();
//      q.add(new Point(sx,sy));
//      int time = 0;
//      while(!q.isEmpty()) {
//         int size = q.size();
//         for(int i = 0 ; i < size; i++) {
//            Point cur = q.poll();
//            if(cur.y == ey && cur.x==ex) {
//               System.out.println("#"+T+" "+time);
//               return;
//            }
//            for(int d = 0 ; d < 4 ; d++) {
//               int ny = cur.y+dir[d][0];
//               int nx = cur.x+dir[d][1];
//               if(ny < 0 || nx < 0 || ny >= N || nx >= N)
//                  continue;
//               if(visited[ny][nx])
//                  continue;
//               if(map[ny][nx]==1 || map[ny][nx]==2 || map[ny][nx]==3)
//                  continue;
//               
//               visited[ny][nx] = true;
//               q.add(new Point(nx,ny));
//            }
//            q.add(new Point(cur.x,cur.y));
//         }
//         time++;
//         UpdateMap();
//         if(time>=4*N*N)
//                break;
//      }
//      System.out.println("#"+T+" -1");
//   }
//   public static void UpdateMap() {
//      for(int i = 0 ; i < N; i++) {
//         for(int j = 0 ; j < N; j++) {
//            if(map[i][j]==2 || map[i][j]==3)
//               map[i][j]++;
//            else if(map[i][j]==4)
//               map[i][j] = 2;
//         }
//      }
//   }
//}