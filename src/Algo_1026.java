import java.util.Arrays;
import java.util.Scanner;

public class Algo_1026 {
	static int N;
	static int A[];
	static int B[];
	static int Atmp[];
	static int Btmp[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N =in.nextInt();
		
		A = new int[N];
		B = new int[N];
		Atmp = new int[N];
		Btmp = new int[N];
		
		for(int i=0;i<N;i++){
			A[i] = in.nextInt();
		}
		for(int i=0;i<N;i++){
			B[i] = in.nextInt();
		}
		
		Arrays.sort(A);
		
		for(int i=0;i<N;i++){
			Atmp[i] = A[i];
		}
		for(int i=0;i<N;i++){
			Btmp[i] = B[i];
		}
		for(int i=0;i<N;i++){
			int max=-1;
			int flag =0 ;
			for(int j=0;j<N;j++){
				if(max<Btmp[j]){
					max = Btmp[j];
					flag = j;
				}
			}
			A[flag] = Atmp[i];
			Btmp[flag] = -1;
//			for(int j =0;j<N;j++){
//				System.out.print(Btmp[j]+" ");
//			}
//			System.out.println("");
		}
		int sum=0;
//		for(int i=0;i<N;i++){
//			System.out.print(A[i]+" ");
//		}
//		System.out.println("");
//		
		for(int i=0;i<N;i++){
			sum+=A[i]*B[i];
		}
		System.out.println(sum);
	}
}
