import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algo_7568 {
	static int N;
	static int arr[][];
	static int rank[];
	static int num=1;
	static int cnt=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N=in.nextInt();
		arr = new int[N][3];
		rank = new int[N];
		for(int i=0;i<N;i++){
			arr[i][0]=in.nextInt();
			arr[i][1]=in.nextInt();
		}


		for(int i=0;i<N;i++){
			int cnt=1;
			for(int j=0;j<N;j++){
				if(j!=i){
					if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){
						cnt++;
					}
				}
			}
			rank[i]=cnt;
		}
		
		for(int i=0;i<N;i++){
			System.out.print(rank[i]+" ");
		}
	}
}
