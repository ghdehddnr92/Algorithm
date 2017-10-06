import java.util.Scanner;

public class Algo_1182 {
	static int N,S;
	static int arr[];
	static int cnt = 0;
	static int res = 0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		
		N= in.nextInt();
		S= in.nextInt();
		
		arr =new int[N];
		
		for(int i=0;i<N;i++){
			arr[i]= in.nextInt();
		}
		
		for(int i=0;i<N;i++){
			for(int j=i;j<N;j++){
				res += arr[j];
				if(res == S){
					System.out.println("cnt증가");
					cnt++;
				}
				System.out.println("res :" + res);
			}
			res =0;
		}
		System.out.println(cnt);
	}
}
