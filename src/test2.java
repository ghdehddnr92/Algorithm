import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2{

   private static int n, ans, maxin = Integer.MIN_VALUE;
   private static int[][] arrorig, temp;
   private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

   private static int chkMax(int[][] arr) {
      int chkmax = Integer.MIN_VALUE;
      
      for(int i=0; i<n; i++) {
         for(int j=0; j<n; j++) {
            if(arr[i][j]>chkmax)
               chkmax = arr[i][j];
         }
      }
      
      return chkmax;
   }
   public static void showArr(int arr[][]){
	   System.out.println("--------");
	   for(int i=0;i<n;i++){
		   for(int j=0;j<n;j++){
			   System.out.print(arr[i][j]+" ");
		   }
		   System.out.println("");
	   }
   }
   private static void dfs(int[][] arr, int dir, int cnt) {
      if (cnt == 4) {
         int ans = chkMax(arr);
         maxin = Math.max(ans, maxin);
         return;
      }

      switch (dir) {
      case 0:
         Right(arr);
         showArr(arr);
         for(int i=0; i<4; i++) {
            dfs(arr, i, cnt+1);
         }
         break;
      case 1:
         Down(arr);
         showArr(arr);
         for(int i=0; i<4; i++) {
            dfs(arr, i, cnt+1);
         }
         break;
      case 2:
         Left(arr);
         showArr(arr);
         for(int i=0; i<4; i++) {
            dfs(arr, i, cnt+1);
         }
         break;
      case 3:
         Up(arr);
         showArr(arr);
         for(int i=0; i<4; i++) {
            dfs(arr, i, cnt+1);
         }
         break;
      }
   }

   private static void Right(int[][] arr) { // 0
      boolean visited[][] = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         int cnt = 0;
         while(cnt<n) {
            for(int j=n-2; j>=0; j--) {
               if(arr[i][j]!=0) {
                  if(arr[i][j+1]==0) {
                     arr[i][j+1] = arr[i][j];
                     arr[i][j] = 0;
                  }else if(arr[i][j+1] == arr[i][j] && !visited[i][j+1]) {
                     arr[i][j+1] +=arr[i][j];
                     arr[i][j] = 0;
                     visited[i][j+1] = true;
                  }
               }
            }
            cnt++;
         }
      }


   }
   
   private static void Left(int[][] arr) { // 0
      boolean visited[][] = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         int cnt = 0;
         while(cnt<n) {
            for(int j=1; j<n; j++) {
               if(arr[i][j]!=0) {
                  if(arr[i][j-1]==0) {
                     arr[i][j-1] = arr[i][j];
                     arr[i][j] = 0;
                  }else if(arr[i][j-1] == arr[i][j] && !visited[i][j-1]) {
                     arr[i][j-1] +=arr[i][j];
                     arr[i][j] = 0;
                     visited[i][j-1] = true;
                  }
               }
            }
            cnt++;
         }
      }
      
      
   }
   
   private static void Up(int[][] arr) { // 0
      boolean visited[][] = new boolean[n][n];
      for (int j = 0; j < n; j++) {
         int cnt = 0;
         while(cnt<n) {
            for(int i=1; i<n; i++) {
               if(arr[i][j]!=0) {
                  if(arr[i-1][j]==0) {
                     arr[i-1][j] = arr[i][j];
                     arr[i][j] = 0;
                  }else if(arr[i-1][j] == arr[i][j] && !visited[i-1][j]) {
                     arr[i-1][j] +=arr[i][j];
                     arr[i][j] = 0;
                     visited[i-1][j] = true;
                  }
               }
            }
            cnt++;
         }
      }
      
   }
   
   private static void Down(int[][] arr) { // 0
      boolean visited[][] = new boolean[n][n];
      for (int j = 0; j < n; j++) {
         int cnt = 0;
         while(cnt<n) {
            for(int i=n-2; i>=0; i--) {
               if(arr[i][j]!=0) {
                  if(arr[i+1][j]==0) {
                     arr[i+1][j] = arr[i][j];
                     arr[i][j] = 0;
                  }else if(arr[i+1][j] == arr[i][j] && !visited[i+1][j]) {
                     arr[i+1][j] +=arr[i][j];
                     arr[i][j] = 0;
                     visited[i+1][j] = true;
                  }
               }
            }
            cnt++;
         }
      }
   /*   for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++)
            System.out.print(arr[i][j] + " ");
         System.out.println();
      }*/
   }
   

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      n = Integer.parseInt(br.readLine());
      arrorig = new int[n][n];
      temp = new int[n][n];

      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < n; j++) {
            arrorig[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 4; i++) {
         maxin = 0;
         dfs(arrorig, i, 1);
         for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
               max = max > maxin ? max : maxin;
            }
         }
      }

      System.out.println(max);
   }

}