import java.util.Scanner;

public class Algo_14501_2 {
	static int N;
	static int day[];
	static int cost[];
	static int max=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N= in.nextInt();
		day  = new int[N];
		cost = new int[N];
		for(int i=0;i<N;i++){
			day[i]=in.nextInt();
			cost[i]=in.nextInt();
		}
		Search(0,0);
		System.out.println(max);
	}
	public static void Search(int a, int value){
		//System.out.println(value);
		//종료 조건
		if(a>=N){
			if(value>max){
				max= value;
			}
			return;
		}
		//subproblem
		if(a+day[a]<=N){
			Search(a+day[a], value+cost[a]);
		}
		Search(a+1, value);
	}
}
