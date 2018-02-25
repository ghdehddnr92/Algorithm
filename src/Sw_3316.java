import java.util.Scanner;

public class Sw_3316 {
	static int T;
	static long result;
	static String line;
	static int dp[][];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			line = in.next();
			int N= line.length();
			dp = new int[N+1][1<<4];
			dp[0][1]=1;
			
			for(int i=0;i<N;i++){

				int manage = (1<<changeChar(line.charAt(i)));

				for(int j=1;j<16;j++){ //첫째날 총 경우의수 
					for(int k=1;k<16;k++){ // 둘째날 총 경우의수 
						if((j & k) < 0|| (k & manage) < 0){
							continue;
						}
						dp[i+1][k] = (dp[i+1][k]+dp[i][j]) % 1000000007;
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
	public static int changeChar(char c){
		return (c-'A');
	}
}