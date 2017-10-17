import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1949_2 {
	static int T;
	static int N,K;
	static int arr[][];
	static int max =0;
	static boolean visited[][];
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		String line;
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			line= br.readLine();
			st = new StringTokenizer(line);
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			arr = new int [N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				line = br.readLine();
				st = new StringTokenizer(line);
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]>max){
						max =arr[i][j];
					}
				}
			}
			//showArr();
			
		}
	}
	public static void DFS(int y,int x){
		
	}
	public static void showArr(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
