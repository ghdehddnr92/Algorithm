import java.util.Scanner;

public class Algo_14889 {
	static int N;
	static int arr[][];
	static int A[];
	static int B[];
	static int aSum;
	static int bSum;
	static long res;
	static long min=999999;
	static boolean flag = false;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
				
		N = in.nextInt();
		arr= new int[N+1][N+1];
		for(int i =1;i<=N;i++){
			for(int j=1;j<=N;j++){
				arr[i][j] = in.nextInt();
			}
		}
		
		A= new int[N/2]; //스타트
		B = new int[N/2];//링크
		combination(0,N,N/2,1);
		System.out.println(min);
	}
	
	public static void combination(int index, int n, int r, int target){
		if(r==0){
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
			for(int i=0;i<A.length-1;i++){
				for(int j=i+1;j<A.length;j++){
					aSum += (arr[A[i]][A[j]]+arr[A[j]][A[i]]);
					bSum += (arr[B[i]][B[j]]+arr[B[j]][B[i]]);
				}
			}
			if(aSum>=bSum){
				res = aSum-bSum;
			}
			else{
				res = bSum-aSum;
			}
			if(res<min){
				min = res;
			}
			aSum = 0;
			bSum = 0;
			return;
		}
		else if(target == N+1){
			return;
		}
		else{
			A[index] = target;
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
}
