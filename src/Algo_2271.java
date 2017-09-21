import java.util.Arrays;
import java.util.Scanner;

public class Algo_2271 {
	static int N;
	static int arr[];
	static int max=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N=in.nextInt();
		arr=new int[N];
		
		for(int i=0;i<N;i++){
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
	
		for(int i=0;i<N;i++){
			if(max<arr[i]*(N-i)){
				max=arr[i]*(N-i);
			}
		}
		System.out.println(max);
	}
}
