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
		
		A= new int[N/2+1];
		B = new int[N/2+1];
		combination(A,N,N/2,1,1);
		System.out.println(min);
	}
	public static void combination(int A[], int n,int r, int index, int target){
		if(r==0){ //출
			int bIndex=1;
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N/2;j++){
					if(A[j]==i){
						flag=true;
					}
				}
				if(flag==false){
					B[bIndex]=i;
					bIndex++;
				}
				flag=false;
			}
//			for(int i=1;i<=N/2;i++){
//				System.out.print("A : "+A[i]+" ");
//			}
//			System.out.println("");
//			for(int i=1;i<=N/2;i++){
//				System.out.print("B : "+B[i]+" ");
//			}
//			System.out.println("");
			
			for(int i=1;i<=N/2-1;i++){
				for(int j=2;j<=N/2;j++){
					if(i!=j){
						aSum+=(arr[A[i]][A[j]]+arr[A[j]][A[i]]);
						bSum+=(arr[B[i]][B[j]]+arr[B[j]][B[i]]);
					}
				}
			}
			if(aSum>=bSum){
				res = aSum-bSum;
			}
			else{
				res = bSum-aSum;
			}
			
			if(min>res){
				min = res;
			}
			res =0;
			aSum=0;
			bSum=0;
			return;
		}
		else if(target == n){
			return;
		}
		A[index]=target;
		combination(A,n,r-1,index+1,target+1);
		combination(A,n,r,index,target+1);
	}
}
