import java.util.Scanner;

public class Algo_14501_3 {
	static int N;
	static int day[];
	static int money[];
	static int max =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		day = new int[N];
		money = new int[N];


		for(int i=0;i<N;i++){
			day[i] = in.nextInt();
			money[i] = in.nextInt();
		}

		dfs(0,0);

		System.out.println(max);
	}
	public static void dfs(int cur, int sum){
		if(cur >=N){
			if(sum>max){
				max = sum;
			}
			return;
		}

		//현재 더했을 경우.
		if(cur+day[cur]<=N){
			dfs(cur+day[cur],sum+money[cur]);
		}
		//안 더했을 경우.
		dfs(cur+1,sum);
	}
}
