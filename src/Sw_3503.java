import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_3503 {
	static int T,N;
	static int arr[];
	static int max =0;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			N= Integer.parseInt(br.readLine());
			st =new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i=0;i<N;i++){
				arr[i] =  Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			for(int i=N-1;i>=2;i--){
				if(max<arr[i]-arr[i-2]){
					max = arr[i] - arr[i-2];
				}
			}
			System.out.println("#"+t+" "+max);
			max =0;
		}
	}
}
