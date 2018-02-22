import java.util.Scanner;

public class Sw_1865 {
	static int T;
	static int N;
	static int arr[][];
	static int tmp[];
	static boolean visited[];
	static double result =1;
	static double max = 0;
	static int D[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			arr = new int[N+1][N+1];
			D = new int[1<<N];
			visited = new boolean[N+1];

			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					arr[i][j] = in.nextInt();
				}
			}
			
			D[1] = arr[0][0];
			for(int i=0;i<(1<<N);i++){
				for(int j=0;j<N;j++){
					if((i & (1<<j))>0){
	
					}
				}
			}
			
			System.out.print("#"+t+" ");
			System.out.printf("%.6f",max*100);
		}
	}
}