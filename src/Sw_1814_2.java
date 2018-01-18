import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1814_2 {
	static int T;
	static int N;
	static int arr[][];
	static int check[][];
	static boolean tmp[][];
	static boolean visited[];
	static int cnt = 0;
	static String result;

	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N];
			tmp = new boolean[N][N];
			visited = new boolean[N*N];
			for(int i=0;i<2;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve();

			if(cnt ==1){
				result = "Yes";
			}
			else{
				result = "No";
			}
			System.out.println("#"+t+" "+result);
			//System.out.println(cnt);
			cnt=0;
		}
	}
	public static void solve(){
		check = new int[2][N];
		
		for(int i=0;i<(1<<(N*N));i++){
			for(int j=0;j<(N*N);j++){

				if((i & (1<<j)) >0){
					check[0][j%N]++;  //행 
					check[1][j/N]++;  //열
	
					if(arr[0][j%N]<check[0][j%N] || arr[1][j/N]<check[1][j/N]){
						break;
					}
				}
			}
			boolean flag = true;

			for(int a=0;a<2; a++){
				for(int b= 0;b<N; b++){
					if(arr[a][b]!=check[a][b]){
						flag = false;
						break;
					}
				}
			}

			if(flag == true){
				cnt++;
			}

			resetCheck();
		}
		return;
	}

	public static void resetCheck(){
		for(int i=0;i<2;i++){
			for(int j=0;j<N;j++){
				check[i][j] = 0;
			}
		}
	}
}
