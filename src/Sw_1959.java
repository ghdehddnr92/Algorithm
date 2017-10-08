import java.util.Scanner;

public class Sw_1959 {
	static int T;
	static int N,M;
	static int arr1[];
	static int arr2[];
	static int max= 0;
	static int res=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		
		for(int t= 0;t<T;t++){
			N=in.nextInt();
			M= in.nextInt();
			
			arr1 = new int[N];
			arr2 = new int[M];
			
			for(int i=0;i<N;i++){
				arr1[i]=in.nextInt();
			}
			for(int j=0;j<M;j++){
				arr2[j]=in.nextInt();
			}
			
			if(N>=M){
				for(int i=0;i<N;i++){
					for(int j=i;j<M+i;j++){
						res+=arr1[j]*arr2[j];
					}
					if(res>max){
						max=res;
					}
				}
			}
			else{
				for(int i=0;i<M;i++){
					for(int j=i;j<N+i;j++){
						res+=arr1[j]*arr2[j];
					}
				}
				if(res>max){
					max=res;
				}
			}
			System.out.println(max);
			res=0;
			max=0;
		}
	}
}
