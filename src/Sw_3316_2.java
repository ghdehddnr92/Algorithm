import java.util.Scanner;

public class Sw_3316_2 {
	
	static int T;
	static long result;
	static int N;
	static int arr[];
	static boolean visited[];
	static boolean first[];
	static boolean second[];
	static int keyPerson =0;
	static int dp[][];
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){

			String line = in.next();
			N = line.length();
			dp = new int[N+1][1<<4];
			for(int i=0;i<N;i++){
				int manage = 1 << changeChar(line.charAt(i));
				
				for(int j=1;j<16;j++){ // 첫날 
					for(int k=1;k<16;k++){  // 둘째날 
						if((j&k) < 0 || (k&manage)<0){
							continue;
						}
						else{
							 dp[i+1][k] = (dp[i+1][k]+dp[i][j])% 1000000007;
						}
 					}
				}
			}
			  for (int i = 0; i < 16; i++){
				  result = (result + dp[N][i]) % 1000000007;  
			  }

			System.out.println("#"+t+" "+result);
			result=0;
		}
	}
	public static int changeChar(char a){
		return (int)(a - 'A');
	}
}
