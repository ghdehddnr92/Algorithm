import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_3410 {
	static int T;
	static int N,M;
	static int arr[][]; // 0이면 W, 1이면 E
	static long result =0;
	static long min = Integer.MAX_VALUE;
	public static void main(String[]args) throws NumberFormatException, IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
	
			arr =new int[M+1][N];
			
			for(int i=0;i<M;i++){
				String line = br.readLine();
				for(int j=0;j<N;j++){
					 if(line.charAt(j)=='W'){
						 arr[i][j] = 0;
					 }
					 else{
						 arr[i][j] = 1;
					 }
				}
			}
			checkW();
			//showArr();
			solve();
			
			System.out.println("#"+t+" "+result+" "+(result+1));
			result=0;
			min =Integer.MAX_VALUE;
		}
	}
	public static void solve(){

		long sum =0;
	
		for(int j=0;j<N;j++){
			sum+=arr[M][j];
		}
		min =sum;
		result =0;
		
		for(int i=0;i<N;i++){
			sum = 0;
			for(int j=i;j>=0;j--){
				sum+=(M-arr[M][j]);
			}
			for(int j=i+1;j<N;j++){
				sum+=arr[M][j];
			}
			if(sum<min){
				min = sum;
				result=i+1;
			}
		}
		sum =0;
		
		for(int j=N-1;j>=0;j--){
			sum+=(M-arr[M][j]);
		}
		if(sum<min){
			min = sum;
			result =N;
		}
	}
	public static void checkW(){

		for(int i=0;i<N;i++){
			int wCnt=0;
			for(int j=0;j<M;j++){
				if(arr[j][i]==0){
					wCnt++;
				}
			}
			arr[M][i] = wCnt; // E 의 갯수는 M-wCnt;
		}
	}
	public static void showArr(){
		for(int i=0;i<M+1;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
