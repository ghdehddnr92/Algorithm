
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo_2105_2{

   private static int t;
   private static int n;
   private static int[][] map;
   private static boolean[][] visited;
   private static ArrayList<Integer> desert;
   private static int[] row = { 1, 1, -1, -1 };
   private static int[] col = { 1, -1, -1, 1 };
   private static int startr;
   private static int startc;
   private static int max;

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      solution();
   }

   private static void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      t = Integer.parseInt(br.readLine());
      StringTokenizer st = null;
      desert = new ArrayList<>();
      int testcase = 0;
      while (--t >= 0) {
         ++testcase;
         n = Integer.parseInt(br.readLine());
         map = new int[n][n];
         visited = new boolean[n][n];

         for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
         }

         for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
               startr = i;
               startc = j;
               dfs(i, j, 0);
               desert.clear();
            }
         }

         max = (max != 0) ? max : -1;
         System.out.println("#" + testcase + " " + max);
         max = 0;

      }
   }

   private static void dfs(int r, int c, int d) {

      visited[r][c] = true;
      desert.add(map[r][c]);

      int tmpr = r + row[3];
      int tmpc = c + col[3];

      if ((d == 2 || d == 3) && tmpr >= 0 && tmpr < n && tmpc >= 0 && tmpc < n && tmpr == startr && tmpc == startc) {
         max = Math.max(max, desert.size());
         visited[tmpr][tmpc] = false;
         return;
      }

      for (int k = d; k < 4; ++k) {
         int nr = r + row[k];
         int nc = c + col[k];

         if (nr >= 0 && nr < n && nc >= 0 && nc < n && !desert.contains(map[nr][nc]) && !visited[nr][nc]) {
            dfs(nr, nc, k);

            visited[nr][nc] = false;
            desert.remove(desert.size() - 1);
         }
      }
   }
}