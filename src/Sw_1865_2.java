import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sw_1865_2 {
   static double probability[][];
   static double dp[];
   static int N;
   static HashMap<Integer,Integer>[] list;
   public static void main(String...msg) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int TestCase = Integer.parseInt(br.readLine());
      probability = new double[16][16];
      list = new HashMap[17];
      for(int i = 0 ; i <=16 ; i++) 
         list[i] = new HashMap<Integer,Integer>();
      
      dp = new double[1<<16];
      for(int T = 1; T<=TestCase; T++) {
         N = Integer.parseInt(br.readLine());
         Arrays.fill(dp, 0);
         for(int i = 0 ; i <=N ; i++) {
            list[i].clear();
         }
         //처음 초기화
         list[0].put(0, 1);
         for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
               probability[i][j] = (double)Integer.parseInt(st.nextToken()) / 100;
            }
         }
         for(int i = 1 ; i<=N; i++)
         setDP(i);
               
         System.out.printf("#%d %.6f\n",T,dp[(1<<N)-1]*100);
      }
   }

   public static void setDP(int num) {
         for(Integer before : list[num-1].keySet()) {
            for(int i =N-1; i >= 0; i--) {
               if((before & (1<<i)) == 0 ) {
                  if(num!=1)
                     dp[before|(1<<i)] = Math.max(dp[before] * probability[num-1][N-i-1], dp[before|(1<<i)]);
                  else
                     dp[before|(1<<i)] = probability[num-1][N-i-1];
                  list[num].put(before|(1<<i), 1);
               }
            }
      }
   }
}