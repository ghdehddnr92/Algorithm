import java.util.Scanner;

 // 코드 참고하기!!


public class Sw_3234_2 {
   static int dp[][][];
   static int N;
   static int list[];
   static boolean used[];
   static int max=0;
   
   public static void main(String...msg) {
      Scanner sc = new Scanner(System.in);
      int TestCase = sc.nextInt();
      used = new boolean[1000];
      for(int T = 1; T<= TestCase; T++) {
      
         N = sc.nextInt();
         max=0;
         list = new int[N];
         for(int i = 0 ; i < N; i++){
            int v = sc.nextInt();
            list[i] = v;
            max+=v;
         }
         
         dp = new int[N][1<<N][max+1];
         System.out.println("#"+T+" "+DP2(0,0,0,0));
      }
   }
   public static int test() {
      int sum = 0;
      for(int i = 0 ; i < N; i++) {
         if(used[list[i]]) {
            sum+=(1 << i);
         }
      }
      return sum;
   }
   /**dp[순서][사용된추][왼쪽저울값] = dp[순서+1][사용되었던추+사용한추][왼쪽저울값] + dp[순서+1][사용되었던추+사용한추][왼쪽저울값];
    *                                 (왼쪽의 경우)                     (오른쪽의 경우)
    */
   public static int DP2(int index,int value,int leftsum,int rightsum) {
      if(leftsum <rightsum) {
         return 0;
      }   
      if(leftsum > max || rightsum > max || index > N)
         return 0;
      if(index==N) { 
         return 1;
      }
      if(dp[index][value][leftsum]!=0) {
         return dp[index][value][leftsum];
      }
      for(int i = 0 ; i <N; i++) {
         int a = list[i];
         if(used[a])
            continue;
         used[a] = true;
   
         dp[index][value][leftsum]+=DP2(index+1,test(),leftsum+a,rightsum);
         if(rightsum+a <= leftsum)
         dp[index][value][leftsum]+=DP2(index+1,test(),leftsum,rightsum+a);
         used[a] = false;
      }
      return dp[index][value][leftsum];
   }
}