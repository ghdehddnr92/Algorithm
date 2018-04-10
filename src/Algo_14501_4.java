import java.util.Scanner;

public class Algo_14501_4 {
	static int N;
	static int day[];
	static int price[];
	static int max =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N= in.nextInt();

		day = new int[N];
		price = new int[N];

		for(int i=0;i<N;i++){
			day[i] = in.nextInt();
			price[i] = in.nextInt();
		}
		dfs(0,0);
		System.out.println(max);

	}
	public static void dfs(int cur, int sum){
		if(cur >=N){
			if(max < sum){
				max = sum;
			}
			return;
		}

		if(cur+day[cur]<=N){
		//	System.out.println(cur);
			dfs(cur+day[cur],sum+price[cur]);
		}
		dfs(cur+1,sum);
	}
}
