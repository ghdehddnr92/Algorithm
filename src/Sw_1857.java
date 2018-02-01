import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1857 {
	
	static int T;
	static int N,K;
	static int arr[][];
	static int min = Integer.MAX_VALUE;
	static int sum;
	public static void main(String[]args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1;t<=T;t++){
			st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sum =0;
			for(int i=0;i<N;i++){
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum+=arr[i][j];
				}
			}
			
			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
}
