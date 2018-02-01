import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1265 {
	static int T;
	static int N,P;
	static long max =1;
	static boolean visited[];
	static int arr[];
	public static void main(String[]args) throws NumberFormatException, IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
	
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			visited = new boolean[P];
			arr = new int[P];
			solve();
			System.out.println("#"+t+" "+max);
			max=1;
		}
	}
	public static void solve(){
		for(int i=0;i<P;i++){
			arr[i] = N/P;
		}
		for(int i=0;i<N%P;i++){
			arr[i]+=1;
		}

		for(int i=0;i<P;i++){
			max= max*arr[i];
		}
	}
}
