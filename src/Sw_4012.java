import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw_4012 {
	static int T,N;
	static int arr[][];

	static int A[];
	static int B[];
	static boolean visited[];
	static int tmpA[];
	static int tmpB[];
	static int min =Integer.MAX_VALUE;
	static int aRes =0;
	static int bRes =0;
	static int res =0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			A = new int[N/2];
			B = new int[N/2];

			tmpA = new int[2];
			tmpB = new int[2];
			visited = new boolean[N+1];

			for(int i=1;i<=N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0,N,N/2,1);
			
			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}	
	}
	public static void combination(int index, int n, int r, int target){
		if(r == 0){
			int idx=0;
			for(int i=1;i<=N;i++){
				boolean flag = true;
				for(int j=0;j<A.length;j++){
					if(A[j]==i){
						flag =false;
						break;
					}
				}
				if(flag == true){
					B[idx]=i;
					idx++;
				}
			}
			aRes=0;
			bRes=0;
			combination2(0,N/2,2,0);
			combination3(0,N/2,2,0);
			
			if(aRes>=bRes){
				res = aRes-bRes;
			}
			else{
				res = bRes-aRes;
			}
			if(res<min){
				min = res;
			}
			res =0;
		}
		else if(target == n+1){
			return;
		}
		else{
			A[index] = target;
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
	public static void combination2(int index, int n, int r, int target){
		if(r == 0){		
			aRes += ((arr[tmpA[0]][tmpA[1]])+(arr[tmpA[1]][tmpA[0]]));
		}
		else if(target == n){
			return;
		}
		else{
			tmpA[index] = A[target];
			combination2(index+1,n,r-1,target+1);
			combination2(index,n,r,target+1);
		}
	}
	public static void combination3(int index, int n, int r, int target){
		if(r == 0){
			bRes += ((arr[tmpB[0]][tmpB[1]])+(arr[tmpB[1]][tmpB[0]]));
		}
		else if(target == n){
			return;
		}
		else{
			tmpB[index] = B[target];
			combination3(index+1,n,r-1,target+1);
			combination3(index,n,r,target+1);
		}
	}
}
