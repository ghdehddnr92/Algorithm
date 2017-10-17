import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algo_10800 {
	static int N;
	static int arr[][];
	static int result[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new int[N][3];
		result = new int[N];
		for(int i=0;i<N;i++){
				arr[i][0]=i+1;
				for(int j= 1;j<3;j++){
					arr[i][j] = in.nextInt();
				}
			}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2[2], o1[2]);
			}
		});
		showArr();
		
		for(int i=0;i<N;i++){
			for(int k=i+1;k<N;k++){
				if(arr[i][1]!=arr[k][1]){
					result[arr[i][0]-1]+=arr[k][2];
				}
			}
		}
		
		for(int i=0;i<N;i++){
			System.out.println(result[i]);
		}
	}
	public static void showArr(){
		for(int i=0;i<N;i++){
			for(int j=0; j<3;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
