import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_1916_2{
   static final int INF = 1000000000;
   static int N;
   static int M;
   static int w[][];
   static int d[];
   static boolean visited[];
   static int start,end;
   public static void main(String[] args) throws IOException {
    
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      M = Integer.parseInt(br.readLine());

      w = new int[N+1][N+1];
      d = new int[N+1];
      visited = new boolean[N+1];

      for (int i=0; i<N+1; i++) {
         d[i] = INF;
         visited[i] = false;
         for (int j = 0; j < N+1; j++) {
            w[i][j] = INF;
         }
      }
      for (int i = 0; i<M; i++) {

         int a, b;
         int weight;
         StringTokenizer st = new StringTokenizer(br.readLine());
         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
         weight = Integer.parseInt(st.nextToken());

         if (w[a][b] > weight) {
            w[a][b] = weight;
         }
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      dijkstra(start, N, M, w, d, visited);
      System.out.println(d[end]);

   }

   static void dijkstra(int start, int n, int m, int[][] w, int[] d, boolean[] visited) {

      int u;
      int dist;

      d[start] = 0;

      for (int i = 1; i < n + 1; i++) {

         dist = INF + 1;
         u = -1;

         for (int j = 1; j < n + 1; j++) {

            if (!visited[j] && d[j] < dist) {

               u = j;
               dist = d[j];
            }
         }

         for (int j = 1; j < n + 1; j++) {

            if (d[j] > d[u] + w[u][j]) {

               d[j] = d[u] + w[u][j];
            }
         }

         visited[u] = true;
      }
   }
}
