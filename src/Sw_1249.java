import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1249 {
	static int T;
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {0, 0,1,-1};
	static int dy[] = {1,-1, 0, 0};
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		T = Integer.parseInt(br.readLine());
		for(int t= 0;t<T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0;i<N;i++){
				String line = br.readLine();
				for(int j=0;j<N;j++){
					arr[i][j]= Integer.parseInt(line.charAt(j)+"");
				}
			}
			
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println("");
			}
		}
	}
}
