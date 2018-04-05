import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_4008_3 {
	static int T;
	static int N;
	static int cal[];
	static int arr[];
	static int max = -999999;
	static int min = Integer.MAX_VALUE;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T  = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			cal = new int[4];
			arr = new int[N];
			for(int i=0;i<4;i++){
				cal[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(1,0,0,0,0,arr[0]);
			System.out.println("#"+t+" "+(max-min));
		//	System.out.println(max+" "+min);
			max = -9999999;
			min = Integer.MAX_VALUE;
		}
	}
	public static void dfs(int index, int plus, int minus, int mul, int divide, int sum){
		if(index==N){		
		//	System.out.println(plus +" "+minus+" "+mul+" "+divide+" "+sum);
			if(sum > max){
				max = sum;
			}
			if(sum < min){
				min = sum;
			}
			return;
		}
		if(plus < cal[0]){
		
			dfs(index+1,plus+1, minus, mul, divide, sum+arr[index]);
		}
		if(minus < cal[1]){
			dfs(index+1,plus, minus+1, mul, divide, sum-arr[index]);
		}
		if(mul < cal[2]){
			dfs(index+1,plus, minus, mul+1, divide, sum*arr[index]);
		}
		if(divide< cal[3]){
			dfs(index+1,plus, minus, mul, divide+1, sum/arr[index]);
		}
	}
}
