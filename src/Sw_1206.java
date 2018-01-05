import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1206 {
	static int result;
	static int N;
	static int arr[];
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=1;t<=10;t++){
			
			N= Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solve();
			
			System.out.println("#"+t+" "+result);
			result=0;
		}
	}
	public static void solve(){
		for(int i=2;i<N-2;i++){
			if(arr[i-2]<arr[i] && arr[i-1] <arr[i] && arr[i+1] <arr[i] && arr[i+2] <arr[i]){
				result+=arr[i]-Math.max(Math.max(arr[i-2], arr[i-1]) , Math.max(arr[i+1], arr[i+2]));
			}
			else{
				continue;
			}
		}
	}
}
