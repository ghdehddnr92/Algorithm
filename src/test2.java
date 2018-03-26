
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2 {

   private static int N, M, maxone;
   private static int[][] arr;
   private static boolean visited[][];
   private static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

   private static void find(int outline) {

      if (outline == 0) {
         return;
      }
      int temp = 0;
      boolean flag = false;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            temp = center(outline, i, j);
            if (temp * M - (outline * outline + (outline - 1) * (outline - 1)) >= 0) {
               if (temp > maxone) {
                  maxone = temp;
               }
            }
         }
      }
/*
      if (flag)
         return maxone;
      else*/
         find(outline - 1);

   }

   private static int center(int k, int row, int col) {
      int time = 1;
      int one = 0;
      visited = new boolean[N][N];
      one += arr[row][col];
      visited[row][col] = true;
      int nextrow, nextcol;
      Queue<Point> que = new LinkedList<>();
      Queue<Point> que2 = new LinkedList<>();
      que.add(new Point(row, col));

      while (time < k) {
         while (!que.isEmpty()) {
            Point pos = que.poll();

            for (int i = 0; i < 4; i++) {
               nextrow = pos.x + dir[i][0];
               nextcol = pos.y + dir[i][1];
               if (nextrow < 0 || nextrow >= N || nextcol < 0 || nextcol >= N || visited[nextrow][nextcol]) {
                  continue;
               }
               visited[nextrow][nextcol] = true;
               one += arr[nextrow][nextcol];
               que2.offer(new Point(nextrow, nextcol));
            }
         }
         time++;
         while (!que2.isEmpty())
            que.add(que2.poll());
      }
      
      return one;
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int TestCase = Integer.parseInt(br.readLine());

      for (int tc = 1; tc <= TestCase; tc++) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         arr = new int[N][N];
         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
               arr[i][j] = Integer.parseInt(st.nextToken());
            }
         }
         maxone=1;
         find(N + 1);
         System.out.println("#" + tc + " " + maxone);
      }
      br.close();
   }

}